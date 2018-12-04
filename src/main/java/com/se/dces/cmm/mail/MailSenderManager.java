package com.se.dces.cmm.mail;

import java.util.ArrayList;

public interface MailSenderManager {

	public String sendEMail(ArrayList<EmailContents> mailInfo);
}
