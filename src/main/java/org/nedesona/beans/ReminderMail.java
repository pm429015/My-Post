package org.nedesona.beans;

import java.util.List;

import org.apache.log4j.Logger;
import org.nedesona.beanInterface.SendMail;
import org.nedesona.domain.Dealer;
import org.nedesona.service.DealerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReminderMail implements SendMail {
	private Logger logger = Logger.getLogger(ReminderMail.class);


	@Override
	public void sending(String to, String title, String content, String link) {
		if (to!= null && title != null && content != null && link!= null) {
			System.out.println("Sending email to: "+to+" title: "+title+" content: "+content+" link: "+link);
		}
	}

}
