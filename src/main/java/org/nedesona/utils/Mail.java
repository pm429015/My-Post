package org.nedesona.utils;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class Mail {
	private MailSender mailSender;
	 
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
 
	private void sendMail(String from,String to, String subject, String msg) {
 
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
	}
	
	public void sendMail(String emailTo){
		sendMail("hokuanhsing@gmail.com", emailTo,"Hello","<h2>Good Job</h2>");
	}

}
