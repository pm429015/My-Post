package org.nedesona.service.impl;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.nedesona.dao.UserDao;
import org.nedesona.domain.User;
import org.nedesona.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {

	private static final Random RANDOM = new SecureRandom();
	public static final int PASSWORD_LENGTH = 8;

	@Autowired
	private UserDao userDao;

//	@Override
//	public void addNewUser(User user) {
//		userDao.addNewUser(user);
//	}

//	@Override
//	public BookmarkUser validateUser(Map<String, Object> data) {
//		return userDao.validateUser(data);
//	}
//
//	@Override
//	public String generateRandomPassword() {
//		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
//		String pw = "";
//		for (int i = 0; i < PASSWORD_LENGTH; i++) {
//			int index = (int) (RANDOM.nextDouble() * letters.length());
//			pw += letters.substring(index, index + 1);
//		}
//		return pw;
//	}
//
//	@Override
//	public void updatePassword(BookmarkUser user) {
//		userDao.updatePassword(user);
//		
//	}

	@Override
	public void checkUserExist(User user) {
		// Add the user if not exist
		if(!userDao.checkUserExist(user)){
			Date timeStamp = Calendar.getInstance().getTime();
			user.setDoj(timeStamp);
			userDao.addNewUser(user);
		}
	}

}
