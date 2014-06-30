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
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.nedesona.service.CommentManager;
import org.nedesona.service.DealManager;
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
public class PostController {

	private Logger logger = Logger.getLogger(PostController.class);

	@Autowired
	private PostManager postManager;

	@Autowired
	private DealManager dealManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private CommentManager commentManager;

	@RequestMapping(value = "/newPost")
	public ModelAndView getPost() {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.debug("Connect to new post page");
		return new ModelAndView("addPost", model);
	}

	@RequestMapping(value = "/postsShow")
	public ModelAndView postsShow() {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.debug("Post list View");
		model.put("postList", postManager.getPostList());

		return new ModelAndView("postsView", model);
	}

	@RequestMapping(value = "/postDone")
	public ModelAndView postDone() {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Post done");
		return new ModelAndView("postThankYou", model);
	}
	
	@RequestMapping(value = "/insertPost")
	public ModelAndView insertPost(@RequestParam(value = "email") String email,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "name") String name,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Insert a new post");
		
		// Check if user exist, add the user if doesn't exist
		User returnUser = userManager.searchUser("email", email);
		if (returnUser == null) {
			returnUser = new User();
			returnUser.setEmail(email);
			returnUser.setFirstName(name);
			userManager.addUser(returnUser);
		}
		
		//Create a new post and save it
		Post post = new Post();
		post.setTitle(title);
		post.setDescription(description);
		post.setUser(returnUser);
		
		postManager.savePost(post);
		
		
		return new ModelAndView("postThankYou", model);
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public @ResponseBody
	Object saveReply(@RequestParam(value = "email") String email,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "deal_id") String dealID) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn(email+" "+content+" "+dealID);
		User user = userManager.searchUser("email", email);
		Deal forWhichDeal = dealManager.searchBy("id", dealID);
		Comment comment = new Comment();
		//define user and for which deal 
		if (user != null && comment != null ) {
			comment.setContent(content);
			comment.setUser(user);
			comment.setDeal(forWhichDeal);
		}
		
		commentManager.saveComment(comment);
		dealManager.addComment(comment);
		
		return model;
	}

	@RequestMapping(value = "/{id}")
	public String view(@PathVariable String id, Model model) throws Exception {
		Post post = postManager.viewById(id);
		Set<Deal> outputDeals = new HashSet<Deal>();
		if (post != null) {
			
			Map<String, Deal> deals = post.getDeals();
			for (String key : deals.keySet()) {
				outputDeals.add(dealManager.viewById(deals.get(key).getId()  ));
			}
			
			model.addAttribute("post", post);
			model.addAttribute("deals",outputDeals);
			model.addAttribute("user", userManager.searchUser("id", post.getUser().getId()));
			
			return "PostByID";
		}else{
			return "Error";
		}
		

	}



	@RequestMapping(value = "/insertDeal", method = RequestMethod.POST)
	public @ResponseBody
	Object saveDeal(HttpServletRequest request,@RequestParam(value = "email") String email,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "header") String header,
			@RequestParam(value = "id") String postid) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.info("Save a new deal "+email+" content:"+content+" id:"+postid);
		User dealer = userManager.searchUser("email", email);
		Deal deal = new Deal();
		if (dealer!= null) {
			
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
		
		logger.warn("Search Keyword: "+keyword);
		model.put("postList", postManager.search(keyword));
		
		return new ModelAndView("search", model);
	}
	

}
