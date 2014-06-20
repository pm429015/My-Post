package org.nedesona.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Contact;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.spring.bean.SocialAuthTemplate;
import org.nedesona.domain.User;
import org.nedesona.service.UserManager;
import org.nedesona.utils.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialLoginController {
	private Logger logger = Logger.getLogger(SocialLoginController.class);

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private Mail mail;
	
	
	@Autowired
    private SocialAuthTemplate socialAuthTemplate;

	@RequestMapping(value = "/login")
	public ModelAndView showSignUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("sociallogIn", model);
	}
	
	@RequestMapping(value = "/emailProcess", method = RequestMethod.POST)
	public ModelAndView emailLogoin(HttpServletRequest request,@RequestParam(value = "email") String email,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		logger.warn("The email is ");
		User user = new User();
		user.setEmail(email);
		userManager.checkUserExist(user);
		
		logger.warn(user.getEmail());
		mail.sendMail(user.getEmail());
		
		
		mv.setViewName("sociallogIn");
		
		return mv;
	}
	
	@RequestMapping(value = "/authSuccess")
    public ModelAndView getRedirectURL(final HttpServletRequest request)
                    throws Exception {
            ModelAndView mv = new ModelAndView();
            List<Contact> contactsList = new ArrayList<Contact>();
            SocialAuthManager manager = socialAuthTemplate.getSocialAuthManager();
            AuthProvider provider = manager.getCurrentAuthProvider();
            contactsList = provider.getContactList();
            if (contactsList != null && contactsList.size() > 0) {
                    for (Contact p : contactsList) {
                            if (!StringUtils.hasLength(p.getFirstName())
                                            && !StringUtils.hasLength(p.getLastName())) {
                                    p.setFirstName(p.getDisplayName());
                            }
                    }
            }
            mv.addObject("id", provider.getProviderId());
            mv.addObject("profile", provider.getUserProfile());
            mv.addObject("contacts", contactsList);
            mv.setViewName("authSuccess");

            return mv;
    }




}
