package org.nedesona.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.nedesona.service.CommentManager;
import org.nedesona.service.DealManager;
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


	@RequestMapping(value = "/arena")
	public ModelAndView dealArena() {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.debug("Connect to deal arena");
		model.put("postList", postManager.getPostList());
		return new ModelAndView("arena", model);
	}
	
	@RequestMapping(value = "/{id}")
	public ModelAndView view(@PathVariable String id, 
			@RequestParam(value = "token", required = false) String token
			, HttpServletResponse response
			) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Post post = postManager.viewById(id);
		
		// If the post id is valid
		if (post != null) {

			model.put("post", post);
			model.put("user", post.getUser());
			
			// Save token in the cookie
			
			if (token != null) {
				response.addCookie(Controller_utils.bakeCookie("token", token ));
			}
			

			return new ModelAndView("battlefield", model);
		}

		return new ModelAndView("Error", model);

	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public @ResponseBody
	Object saveReply(@RequestParam(value = "email") String email,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "deal_id") String dealID) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn(email + " " + content + " " + dealID);
		User user = userManager.searchUser("email", email);
		Deal forWhichDeal = dealManager.searchBy("id", dealID);
		Comment comment = new Comment();
		// define user and for which deal
		if (user != null && comment != null) {
			comment.setContent(content);
			comment.setUser(user);
			comment.setDeal(forWhichDeal);
		}

		commentManager.saveComment(comment);
		dealManager.addComment(comment);

		return model;
	}

	

	@RequestMapping(value = "/insertDeal", method = RequestMethod.POST)
	public @ResponseBody
	Object saveDeal(HttpServletRequest request,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "header") String header,
			@RequestParam(value = "id") String postid) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.info("Save a new deal " + email + " content:" + content + " id:"
				+ postid);
		User dealer = userManager.searchUser("email", email);
		Deal deal = new Deal();
		if (dealer != null) {

			deal.setRefPost(postid);
			deal.setContent(content);
			deal.setUser(dealer);
			deal.setHeader(header);
		}

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
