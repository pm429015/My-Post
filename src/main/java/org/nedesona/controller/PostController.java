package org.nedesona.controller;

import java.awt.List;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;
import org.nedesona.service.DealManager;
import org.nedesona.service.PostManager;
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

@Controller
public class PostController {

	private Logger logger = Logger.getLogger(PostController.class);

	@Autowired
	private PostManager postManager;

	@Autowired
	private DealManager dealManager;

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

	@RequestMapping(value = "/newPost/save", method = RequestMethod.POST)
	public @ResponseBody
	Object savePost(@RequestBody Post post) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Save a new post");
		postManager.savePost(post);

		return model;
	}

	@RequestMapping(value = "/{id}")
	public String view(@PathVariable String id, Model model) throws Exception {
		Post post = postManager.viewById(id);
		model.addAttribute("post", post);

		logger.debug(post);
		return "PostByID";
	}

	// @RequestMapping(value = "/insertDeal", method = RequestMethod.POST)
	// public Object addComment(@RequestBody Deal deal)
	// throws Exception {
	// Map<String, Object> model = new HashMap<String, Object>();
	// logger.debug("Save a new deal");
	// // dealManager.saveDeal(deal);
	// // Post post = postManager.viewById(deal.getRefPost());
	// // Map<String, Deal> deals = post.getDeals();
	// // deals.put(deal.getId(), deal);
	// // post.setDeals(deals);
	// return model;
	// }

	@RequestMapping(value = "/insertDeal", method = RequestMethod.POST)
	public @ResponseBody
	Object saveDeal(@RequestBody Deal deal) {
		Map<String, Object> model = new HashMap<String, Object>();
		logger.warn("Save a new deal");
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
