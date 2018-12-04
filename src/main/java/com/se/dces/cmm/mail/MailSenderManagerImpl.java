package com.se.dces.cmm.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.se.dces.cmm.mail.EmailContents;

@Service
public class MailSenderManagerImpl implements MailSenderManager {
	
    @Autowired
    private JavaMailSender mailSenderObj;
    
    @Autowired
    private SpringTemplateEngine templateEngine;
	
	public String sendEMail (ArrayList<EmailContents> mailInfo) {
		ListIterator<EmailContents> lst = mailInfo.listIterator();
		
			while(lst.hasNext()) {
				EmailContents thisEmail = lst.next();
				
				setEmailModel(thisEmail);
				
				mailSenderObj.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
		
					MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");	
					
			        Context context = new Context();
			        context.setVariables(thisEmail.getModel());
			        String html = templateEngine.process("email-template", context);
			        
						mimeMsgHelperObj.setTo(thisEmail.getEmailID());
						mimeMsgHelperObj.setFrom(EmailController.emailFromRecipient);				
						mimeMsgHelperObj.setText(html, true);
						mimeMsgHelperObj.setSubject(thisEmail.getSubject());
						
					    }
					});
				}
	return null;
	}
	
	@Value("${name}")
	private String name;
	
	public void setEmailModel (EmailContents emailContents) {

		        Map<String, Object> model = new HashMap<String, Object>();
		        model.put("name", name);
		        model.put("location", "Belgium");
		        model.put("signature", "http://memorynotfound.com");
		        emailContents.setModel(model);
	}
	
}