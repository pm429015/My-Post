package org.nedesona.service.impl;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.nedesona.dao.UserDao;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.nedesona.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
	
	private static final Random RANDOM = new SecureRandom();
	public static final int PASSWORD_LENGTH = 8;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		// Add the user if not exist
		if (!userDao.checkUserExist(user)) {
			Date timeStamp = Calendar.getInstance().getTime();
			user.setDoj(timeStamp);
			userDao.addNewUser(user);
		}
	}
	
	@Override
	public User searchUser(String byemail, String email) {
		User user = userDao.searchUser(byemail, email);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public void insertPost(Post post) {
		Query query = new Query(Criteria.where("id").is(post.getUser().getId() ) );
		Update updateQuery = new Update().set("posts." + post.getId(),post);
		userDao.addPost(query, updateQuery);
	}

	@Override
	public User findbyId(String id) {
		return userDao.findByID(id);
	}
	
}
