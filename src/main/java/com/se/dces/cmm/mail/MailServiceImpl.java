package com.se.dces.cmm.mail;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailSenderManager mailSenderManager;
	
	@Override
	public String sendMail(ArrayList<EmailContents> mailInfo) {
		mailSenderManager.sendEMail(mailInfo);
		return null;
	}
}
