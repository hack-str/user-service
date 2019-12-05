package com.revature.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.revature.models.User;

public class MailService {

	public void sendEmail(User sender, User recipient) {
		Properties properties = new Properties();
		properties.put("mail.smpt.host", "smtp.gmail.com");
		properties.put("mail.smpt.port", "587");
		properties.put("mail.smpt.auth", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.ssl.checkserveridentity", true);

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("", "");
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(""));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient.getEmail()));
			message.setSubject("Someone is interested in your couch!");
			message.setText(sender.get"Test");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
