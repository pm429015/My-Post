package org.nedesona.beans;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.nedesona.beanInterface.SendMail;
import org.nedesona.domain.Dealer;
import org.nedesona.service.DealerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class ReminderMail implements SendMail {
	private Logger logger = Logger.getLogger(ReminderMail.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	

	public void sending(String to, String title, String content, String link) {
		if (to!= null && title != null && content != null && link!= null) {
			MimeMessage mime = this.mailSender.createMimeMessage();
			
			try {
				MimeMessageHelper helper = new MimeMessageHelper(mime, true);
				helper.setFrom("DealArenas@gmail.com");
				helper.setTo(to);
				helper.setSubject(title);
				helper.setText(content, false);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.mailSender.send(mime);
			logger.warn("Send email Done....");
			
		}
	}


	@Override
	public void sending(String to, String title, String content, String link, Boolean ready) {
		if (ready ==true) {
			sending( to,  title,  content,  link);
		}else{
			System.out.println("Sending email to: "+to+" title: "+title+" content: "+content+" link: "+link);
		}
	}

}
