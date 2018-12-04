package com.se.dces.cmm.mail;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.dces.cmm.mail.EmailContents;

@RestController
public class EmailController {
	
	static final String emailFromRecipient = "noreply@schneider-electric.com";

    @Autowired
    private MailService mailService;
    
    
    @PostMapping(value = "/")
    public String getResponse(@Valid @RequestBody ArrayList<EmailContents> emailContents) {
    	mailService.sendMail(emailContents);
    	return "Email Sent";
	}
    
    
    @GetMapping(value = "/")
    public String getService(){
    	return "Mail Service Active!";
    }
}