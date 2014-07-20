package org.nedesona.dao;

import java.util.Map;

import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public interface UserDao {

	void addNewUser(User user);
	
	Boolean checkUserExist(User user);
	
	User searchUser(String byemail,String email);
	
	void addPost(Query query, Update update);

	User findByID(String id);
}
