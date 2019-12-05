package com.revature.util;

import java.util.Properties;

public class MailService {

	public void sendEmail (String recipient) {
		Properties properties = new Properties();
		properties.put("mail.smpt.host", "smtp.gmail.com");
		properties.put("mail.smpt.port", "587");
		properties.put("mail.smpt.auth", "true");
		
	}
	
	
}
