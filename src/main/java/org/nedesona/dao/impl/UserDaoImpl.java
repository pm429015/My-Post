package org.nedesona.dao.impl;

import java.util.Map;

import org.nedesona.dao.UserDao;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired(required = false)
	private MongoTemplate mongoTemplate;

	@Override
	public void addNewUser(User user) {
		mongoTemplate.save(user);
	}

//	@Override
//	public BookmarkUser validateUser(Map<String, Object> data) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("userName").is(data.get("userName"))
//				.and("password").is(data.get("password")));
//		BookmarkUser user = mongoTemplate.findOne(query, BookmarkUser.class,
//				"bookmarkuser");
//		if (user != null) {
//			return user;
//		} else {
//			return null;
//		}
//
//	}



	@Override
	public Boolean checkUserExist(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(user.getEmail()));
		User returnUser = mongoTemplate.findOne(query, User.class);
		if (returnUser == null) {
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public User searchUser(String byemail, String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where(byemail).is(email));
		User returnUser = mongoTemplate.findOne(query, User.class);
		if (returnUser == null) {
			// return null if doesn't exist
			return null;
		}else{
			return returnUser;
		}
	}

	@Override
	public void addPost(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, User.class);
	}

	@Override
	public User findByID(String id) {
		return mongoTemplate.findById(id, User.class);
	}

}
