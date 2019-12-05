package com.revature.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.revature.models.Listing;
import com.revature.models.User;

public class MailService {

	public void sendEmail(User sender, User recipient, Listing listing) {

		 final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		 Properties props = new Properties();
	     props.setProperty("mail.smtp.host", "smtp.gmail.com");
	     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	     props.setProperty("mail.smtp.socketFactory.fallback", "false");
	     props.setProperty("mail.smtp.port", "465");
	     props.setProperty("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.debug", "true");
	     props.put("mail.store.protocol", "pop3");
	     props.put("mail.transport.protocol", "smtp");
	     final String username = "couchforce.hackstr@gmail.com";//
	     final String password = "revcouch1234";
	     try{
	     Session session = Session.getDefaultInstance(props, 
	                          new Authenticator(){
	                             protected PasswordAuthentication getPasswordAuthentication() {
	                                return new PasswordAuthentication(username, password);
	                             }});

	   // -- Create a new message --
	     Message msg = new MimeMessage(session);

	  // -- Set the FROM and TO fields --
	     msg.setFrom(new InternetAddress(username));
	     msg.setRecipient(Message.RecipientType.TO, 
	    		 new InternetAddress(recipient.getEmail()));
	     msg.setSubject("Someone is interested in your couch!");
	     msg.setText(sender.getName() + " is interested in " + listing.getAddress()+ "!\nFeel free to reach out to them at:\n"+sender.getEmail()+"\n"+sender.getPhoneNumber());
	     msg.setSentDate(new Date());
	     Transport.send(msg);
	     System.out.println("Message sent.");
	  }catch (MessagingException e){ System.out.println("Exception: " + e);}
	  }
	}


