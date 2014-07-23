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
import javax.transaction.TransactionManager;

import org.apache.log4j.Logger;
import org.nedesona.beanInterface.SendMail;
import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;
import org.nedesona.domain.Record;
import org.nedesona.domain.User;
import org.nedesona.service.DealManager;
import org.nedesona.service.PostManager;
import org.nedesona.service.RecordManager;
import org.nedesona.service.UserManager;
import org.nedesona.utils.GenerateAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
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
public class PaypalController {
	private static final Logger LOGGER = Logger
			.getLogger(PaypalController.class);
	@Autowired
	private RecordManager recordManager;

	@Autowired
	private SendMail reminderMail;

	@Autowired
	private PostManager postManager;

	@Autowired
	private DealManager dealManager;
	
	@Autowired
	private UserManager userManager;


	InputStream is = PaypalController.class
			.getResourceAsStream("/sdk_config.properties");

	public PaypalController() {
		// init apiContext
		try {
			PayPalResource.initConfig(is);
		} catch (PayPalRESTException e) {
			LOGGER.fatal(e.getMessage());
		}

	}

	@RequestMapping(value = "/paypal")
	public ModelAndView doGetPay(HttpServletRequest req,
			@RequestParam(value = "dealID") String dealID) {
		Map<String, Object> model = new HashMap<String, Object>();
		String accessToken = null;
		APIContext apiContext = null;

		LOGGER.warn("Connected to the paypal, DealID="+dealID);
		Deal deal = dealManager.viewById(dealID);
		if (deal == null ) {
			LOGGER.fatal("Unknown Deal");
			return null;
		}
		try {
			accessToken = GenerateAccessToken.getAccessToken();
			LOGGER.warn("Token : " + accessToken);
			apiContext = new APIContext(accessToken);

		} catch (PayPalRESTException e) {
			LOGGER.warn("APIContext Error");
		}
		// ###Details
		// Let's you specify details of a payment amount.
		Details details = new Details();
		details.setShipping("0");
		details.setSubtotal("1");
		details.setTax("0");

		// ###Amount
		// Let's you specify a payment amount.
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("1");
		amount.setDetails(details);
		
		// Add detail of the  item summary
		Item item = new Item();
		item.setName("DealArenas Fee");
		item.setCurrency("USD");
		item.setPrice("1");
		item.setQuantity("1");
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		
		ItemList itemList = new ItemList();
		itemList.setItems(items);

		// ###Transaction
		// A transaction defines the contract of a
		// payment - what is the payment for and who
		// is fulfilling it. Transaction is created with
		// a `Payee` and `Amount` types
		Transaction transaction = new Transaction();
		transaction.setItemList(itemList);
		transaction.setAmount(amount);
//		transaction.setDescription("Total:	$13");

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
		redirectUrls.setCancelUrl(req.getScheme() + "://" + req.getServerName()
				+ ":" + req.getServerPort() + req.getContextPath()
				+ "/Error?guid=" + guid);
		redirectUrls.setReturnUrl(req.getScheme() + "://" + req.getServerName()
				+ ":" + req.getServerPort() + req.getContextPath()
				+ "/paySuccess?guid=" + guid);
		payment.setRedirectUrls(redirectUrls);

		// Create a payment by posting to the APIService
		// using a valid AccessToken
		// The return object contains the status;
		try {
			Payment createdPayment = payment.create(apiContext);
			LOGGER.warn("Created payment with id = " + createdPayment.getId()
					+ " and status = " + createdPayment.getState());

			// ###Payment Approval Url
			Iterator<Links> links = createdPayment.getLinks().iterator();
			while (links.hasNext()) {
				Links link = links.next();
				if (link.getRel().equalsIgnoreCase("approval_url")) {
					model.put("redirectURL", link.getHref());
					LOGGER.warn("Redirect to " + link.getRel() + " "
							+ link.getHref());
				}
			}
			// Init a record
			Record record = new Record();
			record.setId(guid);
			record.setToken(apiContext.getAccessToken());
			record.setPaymentID(createdPayment.getId());
			record.setDealID(dealID);
			record.setStatus("init");
			recordManager.saveTransaction(record);
			LOGGER.warn("Save reocord");

		} catch (PayPalRESTException e) {
			LOGGER.fatal(e.getMessage());
		}

		return new ModelAndView("paypalBack", model);
	}

	@RequestMapping(value = "confirm")
	public ModelAndView paypal(@RequestParam(value = "payment", required = false) String dealID) {
		Map<String, Object> model = new HashMap<String, Object>();
		LOGGER.warn("Start paypal");
		if (dealID != null) {
			Deal deal = dealManager.viewById(dealID);
			// Unknown deal
			if (deal == null) {
				return new ModelAndView("Error", model);
			}
			// if the deal has status = init 
			if (deal.getStatus().equals("init")) {
				LOGGER.warn("To payment page");
				Post post = postManager.viewById(deal.getRefPost());
				model.put("deal", deal);
				model.put("post", post);
				return new ModelAndView("dealerPayment", model);
			// if deal has paid
			}else if(deal.getStatus().equals("paid")){
				LOGGER.warn("Paid");
				model.put("deal", deal);
				return new ModelAndView("Error", model);
			}else{
				return new ModelAndView("Error", model);
			}
		}else{
			LOGGER.warn("Unknown id");
			return new ModelAndView("Error", model);
		}
		
		
	}

	@RequestMapping(value = "paySuccess")
	public ModelAndView paySuccess(HttpServletRequest req) {
		Map<String, Object> model = new HashMap<String, Object>();

		LOGGER.warn("Pay Success");
		if (req.getParameter("PayerID") != null) {
			LOGGER.warn("issue payment");
			Payment payment = new Payment();
			if (req.getParameter("guid") != null) {
				Record record = recordManager
						.findById(req.getParameter("guid"));
				if (record != null) {
					payment.setId(record.getPaymentID());
					PaymentExecution paymentExecution = new PaymentExecution();
					paymentExecution.setPayerId(req.getParameter("PayerID"));
					try {
						payment.execute(new APIContext(record.getToken()),
								paymentExecution);
					} catch (PayPalRESTException e) {
						LOGGER.fatal(e.getMessage());
						return null;
					}
				}
				// Update record db
				recordManager.updateTransaction(record.getId(), "status",
						"completed");

				// Send email to the buyer
				Deal deal = dealManager.viewById(record.getDealID());
				Post post = postManager.viewById(deal.getRefPost());
				User buyer = userManager.findbyId(post.getUser().getId());
				StringBuffer completeDeal = new StringBuffer();
				completeDeal.append("Out-the-door price: "+deal.getHeader()+"\n Car Make: "+post.getTitle()
						+"\n Model: "+post.getModel()
						+"\n Year: "+post.getYear()
						+"\n Color:"+post.getColor()
						+"\n Specific Options"+post.getDescription()
						+"\n Discussion:\n");
				// Loop through the comments
				for (String key : deal.getComments().keySet()) {
					completeDeal.append(deal.getComments().get(key).getContent()+"\n");
				}
				
				completeDeal.append("\n Dealer Contact Info:\n Name: "+deal.getUser().getUserName()
						+"\n Phone: "+deal.getUser().getPhone()
						+"\n Email: "+deal.getUser().getEmail()
						+"\n Address: "+deal.getUser().getAddress()
						+"\n Zip code: "+deal.getUser().getZipCode());
				
				reminderMail.sending(buyer.getEmail(),
				" Your car offer has confirmed", "The dealer just confirmed the offer of "+ deal.getHeader()+" for "+post.getYear()+" "+post.getColor()+" "+post.getTitle() +" "+post.getModel()+"\n\n" +
				"Offer Summary:\n"+completeDeal.toString()+"\n\n Bring this email with you to the dealership\n\n Share your friends how much you save with this offer <http://localhost:8082/mypost/"+post.getId()+">\n"
				,"Congratulation \n DealArena.com <http://localhost:8082/mypost/>", false);
				postManager.updatePost(post.getId(), "status", "Processing");
				dealManager.updateDeal(deal.getId(), "status", "paid");
			} else {
				LOGGER.fatal("Empty guid");
				return null;
			}
		} else {
			LOGGER.warn("unknown payerID");
			return null;
		}
		return new ModelAndView("paySuccess", model);
	}
}
