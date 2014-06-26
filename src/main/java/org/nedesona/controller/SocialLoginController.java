package org.nedesona.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Contact;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.spring.bean.SocialAuthTemplate;
import org.nedesona.beans.SAKEncryption;
import org.nedesona.domain.User;
import org.nedesona.service.UserManager;
import org.nedesona.utils.Controller_utils;
import org.nedesona.utils.EncyptedObject;
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
	
	SAKEncryption sakencryption = new SAKEncryption();
	
	int expireTime = 3000;
	
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
		User user = new User();
		user.setEmail(email);
		userManager.checkUserExist(user);
		mail.sendMail(user.getEmail());
		mv.setViewName("sociallogIn");
		
		return mv;
	}
	
	@RequestMapping(value = "/emailBack", method = RequestMethod.GET)
	public ModelAndView emailSaveCookies(HttpServletRequest request,@RequestParam(value = "data") String email,
			@RequestParam(value = "key") String key, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		EncyptedObject encyptedObject = new EncyptedObject();
		encyptedObject.setEncryptedData(email.replaceAll("\\s", "+"));
		encyptedObject.setEncryptedKey(key.replaceAll("\\s", "+"));
		String user_email = sakencryption.Decryption(encyptedObject);
		User returnUser = userManager.searchUser("email", user_email);
		if (returnUser!= null) {
			// Bake cookies: name and email
            response.addCookie(Controller_utils.bakeCookie("Name", returnUser.getEmail(), expireTime));
            response.addCookie(Controller_utils.bakeCookie("Email", returnUser.getEmail(), expireTime));
            return new ModelAndView("redirect:/");
		}else{
			mv.setViewName("Error");
			return mv;
		}
		
		
		
	}

	
	@RequestMapping(value = "/authSuccess")
    public ModelAndView getRedirectURL(final HttpServletRequest request, HttpServletResponse response)
                    throws Exception {
            SocialAuthManager manager = socialAuthTemplate.getSocialAuthManager();
            AuthProvider provider = manager.getCurrentAuthProvider();
            
            // save the social user into db
            User user = new User();
            if (!provider.getUserProfile().getEmail().equals("")) {
            	user.setEmail(provider.getUserProfile().getEmail());
			}
            
            if (!provider.getUserProfile().getFirstName().equals("")) {
            	user.setFirstName(provider.getUserProfile().getFirstName());
			}
            
            if (!provider.getUserProfile().getLastName().equals("")) {
            	user.setLastName(provider.getUserProfile().getLastName());
			}
            
            if (!provider.getUserProfile().getGender().equals("")) {
            	user.setGender(provider.getUserProfile().getGender());
			}
            userManager.checkUserExist(user);
            
//            mv.addObject("loggedInUser", user);
//            mv.addObject("profile", provider.getUserProfile());
//            mv.addObject("contacts", contactsList);
            
            // Bake cookies

            response.addCookie(Controller_utils.bakeCookie("Name", provider.getUserProfile().getFirstName(), expireTime));

            response.addCookie(Controller_utils.bakeCookie("Email", provider.getUserProfile().getEmail(), expireTime));
            
            

            return new ModelAndView("redirect:/");
    }


}
