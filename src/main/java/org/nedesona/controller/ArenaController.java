package org.nedesona.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArenaController {

	private Logger logger = Logger.getLogger(ArenaController.class);

	@Autowired
	private PostManager postManager;

	@Autowired
	private DealManager dealManager;

	@Autowired
	private UserManager userManager;

	@Autowired
	private CommentManager commentManager;

	@Autowired
	private DealerManager dealerManager;

	@RequestMapping(value = "/arena")
	public ModelAndView dealArena() {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.debug("Connect to deal arena");
		model.put("postList", postManager.getPostList());
		return new ModelAndView("arena", model);
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView view(@PathVariable String id,
			@RequestParam(value = "token", required = false) String token,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Post post = postManager.viewById(id);

		// If the post id is valid
		if (post != null) {

			model.put("post", post);
			model.put("user", post.getUser());

			// Save token in the cookie
			if (token != null) {
				// Check the token is a valid user
				User user = userManager.searchUser("id", token);
				Dealer dealer = dealerManager.searchByID(token);
				if (user != null || dealer != null) {
					response.addCookie(Controller_utils.bakeCookie("token",
							token));
				} else {
					logger.warn("Unknown Token: " + token);
				}

			}

			return new ModelAndView("battlefield", model);
		}

		return new ModelAndView("Error", model);

	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public @ResponseBody
	Object saveReply(@RequestParam(value = "token") String token,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "deal_id") String dealID) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn(token + " " + content + " " + dealID);
		
		Deal forWhichDeal = dealManager.searchBy("id", dealID);
		if (forWhichDeal != null) {
			// Two kind of user
			Comment comment = new Comment();
			comment.setContent(content);
			comment.setDeal(forWhichDeal);
			User user = userManager.searchUser("id", token);
			// Is the author
			if (user != null) {
				comment.setUser(user);
			}else{
				// Check Buyer
				Dealer dealer = dealerManager.searchByID(token);
				if (dealer != null) {
					comment.setUser(dealer);
				}else{
					logger.warn("Unknown user");
					return null;
				}
			}
			
			
			commentManager.saveComment(comment);
			dealManager.addComment(comment);
			postManager.updateDeal(forWhichDeal);

		} else {
			logger.warn("Unknown deal");
		}
		
		
		return model;
	}

	@RequestMapping(value = "/insertDeal", method = RequestMethod.POST)
	public @ResponseBody
	Object saveDeal(
			HttpServletRequest request,
			@RequestParam(value = "token", required = false) String token,
			@RequestParam(value = "dealHeader") String header,
			@RequestParam(value = "dealContent") String dealContent,
			@RequestParam(value = "dealerName", required = false) String dealerName,
			@RequestParam(value = "dealerEmail", required = false) String dealerEmail,
			@RequestParam(value = "dealerPhone", required = false) String dealerPhone,
			@RequestParam(value = "dealerZip", required = false) String dealerZip,
			@RequestParam(value = "dealerAddress", required = false) String dealerAddress,
			@RequestParam(value = "dealerBrands", required = false) String dealerBrands,
			@RequestParam(value = "id") String postid) {

		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Save a new deal " + header + " content:" + dealContent
				+ " id:" + postid + " dealerName:" + dealerName
				+ " dealerEmail:" + dealerEmail);

		// Case 1: New user
		Dealer dealer = new Dealer();
		if (dealerName != null && dealerEmail != null && dealerPhone != null
				&& dealerZip != null && dealerAddress != null && token == null) {
			dealer.setUserName(dealerName);
			dealer.setEmail(dealerEmail);
			dealer.setPhone(dealerPhone);
			dealer.setAddress(dealerAddress);
			dealer.setZipCode(dealerZip);

			// Optional if the dealer has brands
			if (dealerBrands != null) {
				dealer.setBrands(dealerBrands);
			}
			dealerManager.addDealer(dealer);
			// Case 2: has a token
		} else if (token != null) {
			logger.warn("the return user");
			// Find the dealer
			Dealer returnDealer = dealerManager.searchByID(token);
			if (returnDealer != null) {
				dealer = returnDealer;
			} else {
				return null;
			}
			// Case 3: Error
		} else {
			return null;
		}

		// Create a new deal and add into db
		Deal deal = new Deal();
		deal.setHeader(header);
		deal.setContent(dealContent);
		deal.setRefPost(postid);
		deal.setUser(dealer);
		dealManager.saveDeal(deal);
		postManager.addDeal(deal);

		return model;
	}

	@RequestMapping(value = "/search")
	public ModelAndView search(@RequestParam String keyword) {
		Map<String, Object> model = new HashMap<String, Object>();

		logger.warn("Search Keyword: " + keyword);
		model.put("postList", postManager.search(keyword));

		return new ModelAndView("search", model);
	}

}
