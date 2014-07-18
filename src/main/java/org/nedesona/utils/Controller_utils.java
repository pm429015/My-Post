package org.nedesona.utils;

import java.util.regex.Pattern;

import javax.servlet.http.Cookie;

public class Controller_utils {
	final static int expireTime = 518400;
	
	public static Cookie bakeCookie(String key, String content){
		Cookie cookie = new Cookie(key, content);
		cookie.setMaxAge(expireTime);
        return cookie;
	}
	
	public static boolean checkEMail(String email){
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		
		return pattern.matcher(email).matches();
		
	}
	
}
