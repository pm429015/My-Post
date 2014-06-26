package org.nedesona.utils;

import javax.servlet.http.Cookie;

public class Controller_utils {
	public static Cookie bakeCookie(String key, String content, int expired){
		Cookie cookie = new Cookie(key, content);
		cookie.setMaxAge(expired);
        return cookie;
	}
}
