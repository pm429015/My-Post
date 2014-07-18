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
	private SendMail mailToDealers;


	@RequestMapping(value = "/insertPost")
	public ModelAndView insertPost(@RequestParam(value = "email") String email,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "zip") String zip,
			@RequestParam(value = "miles") String miles,
			@RequestParam(value = "description") String description,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Insert a new post");

		// Check email and if user exist, add the user if doesn't exist
		if (Controller_utils.checkEMail(email)) {
			User returnUser = userManager.searchUser("email", email);
			if (returnUser == null) {
				logger.warn("Create a new User");
				returnUser = new User();
				returnUser.setEmail(email);
				String[] userName = email.split("@");
				returnUser.setUserName(userName[0]);
				userManager.addUser(returnUser);
			}
			// Create a new post and save it
			Post post = new Post();
			post.setTitle(title);
			post.setDescription(description);
			post.setUser(returnUser);
			post.setZip(zip);
			post.setActive(true);
			
			// maintain a email list in the post db and add author email in the list
			List<String> emailList = new ArrayList<String>();
			emailList.add(email);
			post.setEmailList(emailList);
			
			//Call US zip code finder, and return a list of string
			List<String> zipCodelist = new ArrayList<String>();
			zipCodelist.add("1");

			if (!zipCodelist.isEmpty()) {
				List<Dealer> dealerlist = dealerManager.searchDealers("zipCode", zipCodelist);
				
				// Send mail to the target dealers
				mailToDealers.sending(dealerlist);
			}else{
				logger.warn("Empyt Zip code list");
			}
			
			logger.warn("Save the Post to the db");
			postManager.savePost(post);
		}
		
		return new ModelAndView("postThankYou", model);
	}

}
