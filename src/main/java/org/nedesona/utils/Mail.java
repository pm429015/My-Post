package org.nedesona.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.nedesona.beanInterface.Encryption;
import org.nedesona.beans.SAKEncryption;
import org.nedesona.controller.SocialLoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


public class Mail {
	private Logger logger = Logger.getLogger(Mail.class);
	private JavaMailSender mailSender;
	
//	@Autowired
	SAKEncryption sakencryption = new SAKEncryption();
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	private void sendMail(String from, String to, String subject, String htmlmsg) throws MessagingException {
		MimeMessage mime = this.mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(htmlmsg, true);
		this.mailSender.send(mime);
		logger.warn("Send email Done....");
	}

	
	public void sendMail(String emailTo, String returnURL) {
		EncyptedObject enObj=sakencryption.encrpytion(emailTo);
		String returnTo = "http://localhost:8082/mypost/"+returnURL;
		String linkTo ="http://localhost:8082/mypost/emailBack?data="+enObj.getEncryptedData()+"&key="+enObj.getEncryptedKey()+"&path="+returnTo;
		
		try {
			String htmlmsg = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" bgcolor=\"#f2f2f2\"><tbody><tr><td valign=\"top\" style=\"padding:30px 10px\">"+
		"<table width=\"580\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">"+
		"<tbody><tr> <td style=\"padding-bottom:20px\"> <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">"+
		"<tbody> <h3 style=\"font-family:arial;font-size:16px;color:#464646\" align=center >"+"Login Through Your Email"+"</h3>"+
        "</tbody></table> </td> </tr> <tr> <td align=\"center\" valign=\"middle\" bgcolor=\"#e7e8e7\" style=\"padding:30px 40px\">"+
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"49%\" height=\"138\" border=\"0\" align=\"center\" style=\"word-break:break-all\">"+
		"<tbody><tr> <td height=\"138\" valign=\"center\" align=\"center\"> <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">"+
		"<tbody><tr> <td align=\"center\" style=\"word-break:break-all\"><a  style=\"font-family:arial;font-size:16px;font-weight:bold;text-decoration:none;color:#1a74ba\" target=\"_blank\">Please Login</a>"+
		"</td> </tr> <tr> <td align=\"center\" style=\"padding-bottom:20px;font-family:arial;font-size:12px;color:#74767a\">"+
		"The link is available for 24 hours. </td> </tr> <tr> <td align=\"center\"> <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">"+
		"<tbody><tr> <td align=\"center\" bgcolor=\"#990000\" style=\"padding:8px 20px\">"+
		"<a href=\""+linkTo+"\" style=\"display:block;font-family:arial;font-size:14px;font-weight:bold;text-decoration:none;color:#ffffff;line-height:1\" target=\"_blank\">"+
		"Log in Here! </a> </td></tr></tbody></table> </td> </tr> </tbody></table> </td> </tr> </tbody></table>"+
		"</td> </tr> <tr> <td style=\"padding-top:20px;font-family:arial;font-size:14px;line-height:1.75;color:#74767a\">"+
		"You received this message because you are a member of HuHo. </td></tr> </tbody></table></td></tr></tbody></table>";

		sendMail("hokuanhsing@gmail.com", emailTo, "A validation mail from HuHo", htmlmsg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn("Html Email error");
		}
	}
	
}
