package org.nedesona.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nedesona.domain.BookmarkUser;
import org.nedesona.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialLoginController {

	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showSignUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("sociallogIn", model);
	}

//	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
//	public @ResponseBody
//	Object showSignUp(HttpServletRequest request,
//			@RequestBody Map<String, Object> data) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		BookmarkUser user = userManager.validateUser(data);
//		if (user != null) {
//			request.getSession().setAttribute("loggedInUser", user);
//			model.put("isFirstLogin", user.getPassChanged());
//			model.put("user", user);
//			model.put("success", true);
//		} else {
//			model.put("success", false);
//		}
//
//		return model;
//	}

}
