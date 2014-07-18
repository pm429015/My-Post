package org.nedesona.beans;

import java.util.List;

import org.apache.log4j.Logger;
import org.nedesona.beanInterface.SendMail;
import org.nedesona.domain.Dealer;
import org.nedesona.service.DealerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailToDealers implements SendMail {
	private Logger logger = Logger.getLogger(MailToDealers.class);

	@Autowired
	private DealerManager dealerManager;

	@Override
	public void sending(Object dealers) {
		// Loop and sent mails to the target dealers

		if (dealers instanceof List<?>) {
			List<Dealer> dealerlist = (List<Dealer>) dealers;

			if (!dealerlist.isEmpty()) {
				for (Dealer dealer : dealerlist) {
					System.out.println(" Send email to dealers name: " + dealer.getUserName()
							+ " Zip: " + dealer.getZipCode());
				}
			} else {
				logger.warn("Emtpy dealer list");
			}

		} else {
			logger.warn("An unknown object");
		}

	}

}
