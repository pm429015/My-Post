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
import org.nedesona.service.DealerManager;
import org.nedesona.service.PostManager;
import org.nedesona.service.UserManager;
import org.nedesona.utils.Controller_utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="about")
	public ModelAndView about(){
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("about",model);
	}
	
	@RequestMapping(value="howItWorks")
	public ModelAndView howItWorks(){
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("howItWorks",model);
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
							" so I can compare to offers from other dealers."+"\n\n Please response your message through this link <http://localhost:8082/mypost/"+post.getId()+"?token="+dealer.getId()+">", 
							"\n\n Thank you for your help with this."
							,false);
				}
				
			}else{
				logger.warn("Empyt Zip code list");
			}
			
			
		}
		
		return new ModelAndView("postThankYou", model);
	}

}
