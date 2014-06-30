package org.nedesona.service;

import java.util.Map;

import org.nedesona.domain.BookmarkUser;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;

public interface UserManager {

//	void addNewUser(User user);

//	User validateUser(Map<String, Object> data);
//
//	void updatePassword(User user);
	
	void addUser(User user);
	
	User searchUser(String byemail, String email);
	
	void insertPost(Post post);
}
