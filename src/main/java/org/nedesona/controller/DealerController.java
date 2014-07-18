package org.nedesona.controller;

import java.awt.List;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Dealer;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.nedesona.service.CommentManager;
import org.nedesona.service.DealManager;
import org.nedesona.service.DealerManager;
import org.nedesona.service.PostManager;
import org.nedesona.service.UserManager;
import org.nedesona.utils.Controller_utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.util.Hash;

@Controller
public class DealerController {

	private Logger logger = Logger.getLogger(DealerController.class);

	@Autowired
	private DealerManager dealerManager;

	@RequestMapping(value = "/dealerStart")
	public ModelAndView getPost() {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Connect to the dealer controller");
		return new ModelAndView("home", model);
	}
	
	@RequestMapping(value = "/insertDealer")
	public ModelAndView dealArena() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		Dealer dealer = new Dealer();
		dealer.setEmail("email8");
		dealer.setFirstName("dealer8");
		dealer.setLastName("dealer8");
		dealer.setUserName("d8");
		dealer.setZipCode("3");
		
		//save the dealer
		dealerManager.addDealer(dealer);
		
		Dealer dealer1 = new Dealer();
		dealer1.setEmail("email9");
		dealer1.setFirstName("dealer9");
		dealer1.setLastName("dealer9");
		dealer1.setUserName("d9");
		dealer1.setZipCode("3");
		
		//save the dealer
		dealerManager.addDealer(dealer1);
		
		Dealer dealer11 = new Dealer();
		dealer11.setEmail("email10");
		dealer11.setFirstName("dealer10");
		dealer11.setLastName("dealer10");
		dealer11.setUserName("d10");
		dealer11.setZipCode("1");
		
		//save the dealer
		dealerManager.addDealer(dealer11);
		return new ModelAndView("home", model);
	}

}
