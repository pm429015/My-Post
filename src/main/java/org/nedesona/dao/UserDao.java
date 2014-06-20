package org.nedesona.dao;

import java.util.Map;

import org.nedesona.domain.User;


public interface UserDao {

	void addNewUser(User user);

//	User validateUser(Map<String, Object> data);
//
//	void updatePassword(User user);
	
	Boolean checkUserExist(User user);
	
	

}
