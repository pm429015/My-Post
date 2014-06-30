package org.nedesona.utils;

import javax.servlet.http.Cookie;

public class Controller_utils {
	final static int expireTime = 100;
	
	public static Cookie bakeCookie(String key, String content){
		Cookie cookie = new Cookie(key, content);
		cookie.setMaxAge(expireTime);
        return cookie;
	}
}
