package com.se.dces.cmm.mail;

import java.util.Map;
import javax.validation.constraints.NotEmpty;
import com.se.dces.cmm.mail.validator.emaillist.EmailList;

public class EmailContents {

	@EmailList(message = "at least one of the email-IDs is not valid")
	private String[] emailID;
	@NotEmpty(message = "subject can not be empty")
	private String subject;
	
	private String body;

    private Map<String, Object> model;
	
	public EmailContents() {}
	public EmailContents(String[] emailID, String subject, String body) {
		this.emailID = emailID;
		this.subject = subject;
		this.body = body;
	}
	
	public String[] getEmailID() {
		return emailID;
	}
	public String getSubject() {
		return subject;
	}
	public String getBody() {
		return body;
	}
	
	public void setEmailID(String[] emailID) {
		this.emailID = emailID;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
