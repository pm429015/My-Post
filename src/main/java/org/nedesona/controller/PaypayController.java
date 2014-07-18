package org.nedesona.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nedesona.utils.GenerateAccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.core.rest.APIContext;
import com.paypal.core.rest.PayPalRESTException;
import com.paypal.core.rest.PayPalResource;


@Controller
public class PaypayController {
	private static final Logger LOGGER = Logger.getLogger(PaypayController.class);
	
	
	Map<String, String> paymentIDMap = new HashMap<String, String>();
	Map<String, APIContext> apiContextMap = new HashMap<String, APIContext>();
	InputStream is = PaypayController.class.getResourceAsStream("/sdk_config.properties");
	
	public PaypayController(){
		//init apiContext
		try {
			PayPalResource.initConfig(is);
		} catch (PayPalRESTException e) {
			LOGGER.fatal(e.getMessage());
		}
		
	}

	
	@RequestMapping(value = "/paypal")
	public ModelAndView doGetPay(HttpServletRequest req) {
		Map<String, Object> model = new HashMap<String, Object>();
		String accessToken = null;
		APIContext apiContext = null;
		
		LOGGER.warn("Connected to the paypal");
			try {
				accessToken = GenerateAccessToken.getAccessToken();
				LOGGER.warn("Token : "+ accessToken);
				apiContext = new APIContext(accessToken);
				
			} catch (PayPalRESTException e) {
				LOGGER.warn("APIContext Error");
			}
			// ###Details
			// Let's you specify details of a payment amount.
			Details details = new Details();
			details.setShipping("0");
			details.setSubtotal("3");
			details.setTax("0");

			// ###Amount
			// Let's you specify a payment amount.
			Amount amount = new Amount();
			amount.setCurrency("USD");
			// Total must be equal to sum of shipping, tax and subtotal.
			amount.setTotal("3");
			amount.setDetails(details);

			// ###Transaction
			// A transaction defines the contract of a
			// payment - what is the payment for and who
			// is fulfilling it. Transaction is created with
			// a `Payee` and `Amount` types
			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction.setDescription("Total:	$3");

			// The Payment creation API requires a list of
			// Transaction; add the created `Transaction`
			// to a List
			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(transaction);

			// ###Payer
			// A resource representing a Payer that funds a payment
			// Payment Method
			// as 'paypal'
			Payer payer = new Payer();
			payer.setPaymentMethod("paypal");

			// ###Payment
			// A Payment Resource; create one using
			// the above types and intent as 'sale'
			Payment payment = new Payment();
			payment.setIntent("sale");
			payment.setPayer(payer);
			payment.setTransactions(transactions);

			// ###Redirect URLs
			RedirectUrls redirectUrls = new RedirectUrls();
			String guid = UUID.randomUUID().toString().replaceAll("-", "");
			redirectUrls.setCancelUrl(req.getScheme() + "://"
					+ req.getServerName() + ":" + req.getServerPort()
					+ req.getContextPath() + "/Error?guid=" + guid);
			redirectUrls.setReturnUrl(req.getScheme() + "://"
					+ req.getServerName() + ":" + req.getServerPort()
					+ req.getContextPath() + "/paySuccess?guid=" + guid);
			payment.setRedirectUrls(redirectUrls);

			// Create a payment by posting to the APIService
			// using a valid AccessToken
			// The return object contains the status;
			try {
				Payment createdPayment = payment.create(apiContext);
				LOGGER.warn("Created payment with id = "
						+ createdPayment.getId() + " and status = "
						+ createdPayment.getState());
				
				// Temp Store apicontext map for the payment complete action
				apiContextMap.put(guid, apiContext);
				
				// ###Payment Approval Url
				Iterator<Links> links = createdPayment.getLinks().iterator();
				while (links.hasNext()) {
					Links link = links.next();
					if (link.getRel().equalsIgnoreCase("approval_url")) {
						model.put("redirectURL", link.getHref());
						LOGGER.warn("Redirect to "+link.getRel() +" "+link.getHref());
					}
				}
				paymentIDMap.put(guid, createdPayment.getId());
			} catch (PayPalRESTException e) {
				LOGGER.fatal( e.getMessage());
			}
			
		
		return new ModelAndView("paypalBack", model);
	}
	
	@RequestMapping(value = "paypaltest")
	public ModelAndView paypal() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("paypayTest", model);
	}
	
	@RequestMapping(value = "paySuccess")
	public ModelAndView paySuccess(HttpServletRequest req) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		LOGGER.warn("Pay Success");
		if (req.getParameter("PayerID") != null) {
			LOGGER.warn("issue payment");
			Payment payment = new Payment();
			if (req.getParameter("guid") != null) {
				payment.setId(paymentIDMap.get(req.getParameter("guid")));
			}

			PaymentExecution paymentExecution = new PaymentExecution();
			paymentExecution.setPayerId(req.getParameter("PayerID"));
			try {
				payment.execute(apiContextMap.get(req.getParameter("guid")), paymentExecution);
			} catch (PayPalRESTException e) {
				LOGGER.fatal( e.getMessage());
			}
			
			apiContextMap.remove(req.getParameter("guid"));
			paymentIDMap.remove(req.getParameter("guid"));
		}else{
			LOGGER.warn("unknown payerID");
		}
		return new ModelAndView("paySuccess", model);
	}
}
