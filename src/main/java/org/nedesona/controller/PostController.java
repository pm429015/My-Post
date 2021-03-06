package org.nedesona.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nedesona.beanInterface.SendMail;
import org.nedesona.domain.Dealer;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.nedesona.domain.Zip;
import org.nedesona.service.DealerManager;
import org.nedesona.service.PostManager;
import org.nedesona.service.UserManager;
import org.nedesona.service.ZipManager;
import org.nedesona.utils.Controller_utils;
import org.nedesona.utils.ZipSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

	private Logger logger = Logger.getLogger(PostController.class);

	@Autowired
	private PostManager postManager;

	@Autowired
	private UserManager userManager;

	@Autowired
	private DealerManager dealerManager;
	
	@Autowired
	private SendMail reminderMail;
	
	@Autowired
	private ZipManager zipManager;
	
	String domain="http://localhost:8082/mypost/";
	
	@RequestMapping(value="about")
	public ModelAndView about(){
		Map<String, Object> model = new HashMap<String, Object>();
		Zip zip = zipManager.findByZip("81153");
		System.out.println("show: lat:"+zip.getLatitude()+"  long:"+zip.getLongitude());
		List<Double> ranges = ZipSearch.search(zip.getLatitude(),zip.getLongitude(), 25.0);
		
		List<Zip> zips = zipManager.searchZips(ranges.get(0),ranges.get(1),ranges.get(2),ranges.get(3));
		
		for (Zip zip2 : zips) {
			System.out.println(zip2.getZipCode());
		}
		
		return new ModelAndView("about",model);
	}
	

	@RequestMapping(value = "/addDealer", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView dealerJoin(
			@RequestParam(value = "dealerShip") String dealerShip,
			@RequestParam(value = "dealerName") String dealerName,
			@RequestParam(value = "dealerEmail") String dealerEmail,
			@RequestParam(value = "dealerPhone") String dealerPhone,
			@RequestParam(value = "dealerZip") String dealerZip,
			@RequestParam(value = "dealerAddress") String dealerAddress,
			@RequestParam(value = "dealerBrands") String dealerBrands
			) {

		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("start");
		Dealer dealer = new Dealer();
		if (dealerName != null && dealerEmail != null && dealerPhone != null
				&& dealerZip != null && dealerAddress != null && dealerShip != null) {
			dealer.setUserName(dealerName);
			dealer.setEmail(dealerEmail);
			dealer.setPhone(dealerPhone);
			dealer.setAddress(dealerAddress);
			dealer.setZipCode(dealerZip);
			dealer.setDealership(dealerShip);
			dealer.setBrands(dealerBrands);

			dealerManager.addDealer(dealer);
		}
		return new ModelAndView("about", model);
	}
	

	@RequestMapping(value = "/insertPost")
	public ModelAndView insertPost(
			@RequestParam(value = "title") String title,
			@RequestParam(value = "model") String carModel,
			@RequestParam(value = "year") String year,
			@RequestParam(value = "color") String color,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "zip") String zip,
			@RequestParam(value = "miles") String miles,
			@RequestParam(value = "description", required = false) String description,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Insert a new post");

		// Check all attributes and if user exist, add the user if doesn't exist
		if (Controller_utils.checkEMail(email) && title != null && carModel != null && year != null
				&& color != null && name!= null && zip!= null && miles != null) {
			User returnUser = userManager.searchUser("email", email);
			if (returnUser == null) {
				logger.warn("Create a new User");
				returnUser = new User();
				returnUser.setEmail(email);
				returnUser.setUserName(name);
				userManager.addUser(returnUser);
			}
			// Create a new post and save it
			Post post = new Post();
			post.setTitle(title);
			if (description != null) {
				post.setDescription(description);
			}else{
				post.setDescription("");
			}
			
			post.setUser(returnUser);
			post.setZip(zip);
			post.setActive("Active");
			post.setColor(color);
			post.setModel(carModel);
			post.setYear(year);
			
			// maintain a email list in the post db and add author email in the list
			Map<String, String> emailList = new HashMap<String,String>();
			emailList.put(returnUser.getId(),email);
			post.setEmailList(emailList);
			
			logger.warn("Save the Post to the db");
			postManager.savePost(post);
			
			//Call US zip code finder, and return a list of string
			List<String> zipCodelist = new ArrayList<String>();
			zipCodelist.add("2");
			
			if (!zipCodelist.isEmpty()) {
				List<Dealer> dealerlist = dealerManager.searchDealers("zipCode", zipCodelist);
				
				// Send mail to the target dealers
				for (Dealer dealer : dealerlist) {
					// Paste target email, title, post content and link
					reminderMail.sending(dealer.getEmail(),"Looking to purchase a "+post.getYear()+" "+post.getColor()+" "+post.getTitle() +" "+post.getModel(),
							"Dear "+dealer.getUserName()+",\n\n"+"   I am in the marktet for a "+post.getYear()+" "+post.getColor()+" "+post.getTitle() +" "+post.getModel()+
							" with in the next week. I am interested in hearing the lowest full out-the-door you can offer with no other taxes, fees and charges."+
							" Price is my biggest factor. Also, "+post.getDescription()+". Other features are irrelevant. Again, full out-of-door price is requested"+
							" so I can compare to offers from other dealers."+"\n\n Please response your message through this link <"+domain+post.getId()+"?token="+dealer.getId()+">", 
							"\n\n Thank you for your help with this."
							);
				}
				
			}else{
				logger.warn("Empyt Zip code list");
			}
			
			
		}
		
		return new ModelAndView("postThankYou", model);
	}

}
