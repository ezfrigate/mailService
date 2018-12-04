package com.se.dces.cmm.mail;

import java.util.ArrayList;

public interface MailService {

	public String sendMail(ArrayList<EmailContents> mailInfo);
}
