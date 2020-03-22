package com.send.Email;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailMain {

	public static void main(String[] args) {
		
		System.out.println("Mail Sending Mechanism Started");
		final String username ="saliverusaikumar6";
		final String password ="Saliveru@6";
		String fromEmail ="saliverusaikumar6@gmail.com";
		String toEmail ="himabindu.duvvuri@valuelabs.com";
		
		System.out.println("completed Initialization");
		
		Properties pros = new Properties();
		pros.put("mail.smtp.auth", true);
		pros.put("mail.smtp.starttls.enable",true);
		pros.put("mail.smtp.host","smtp.gmail.com");
		pros.put("mail.smtp.port", 587);
		
		Session session = Session.getInstance(pros, new javax.mail.Authenticator() {
			protected PasswordAuthentication  getPasswordAuthentication() {
				return new  PasswordAuthentication(username,password);
			}
		});
		
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("subject is Test");
			msg.setText("Text Message is Hiii");
			
			Multipart emailcontent = new MimeMultipart();
			
			//Text Body
			MimeBodyPart textbody = new MimeBodyPart();
			textbody.setText("This is the Text along with Attachement");
			
			//Attachement Body
			MimeBodyPart pdfatta = new MimeBodyPart();
			pdfatta.attachFile("C:/Users/saikumar.saliveru/Downloads/60135286.pdf");
			
			emailcontent.addBodyPart(textbody);
			emailcontent.addBodyPart(pdfatta);
			
			msg.setContent(emailcontent);
			
			Transport.send(msg);
			System.out.println("Mail Sent SuccessFully");
			
			
		} catch (MessagingException e) {
			System.out.println("The Error is "+	e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
