package org.nedesona.dao.impl;

import java.util.List;
import java.util.Map;

import org.nedesona.dao.DealerDao;
import org.nedesona.dao.UserDao;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Dealer;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class DealerDaoImpl implements DealerDao {

	@Autowired(required = false)
	private MongoTemplate mongoTemplate;

	@Override
	public void addNewDealer(Dealer dealer) {
		mongoTemplate.save(dealer);
	}

	@Override
	// Check user by email
	public Boolean checkDealerExist(Dealer dealer) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(dealer.getEmail()));
		User returnUser = mongoTemplate.findOne(query, User.class);
		if (returnUser == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<Dealer> searchDealers(String field, List<String> list) {
		Query query = new Query();
		query.addCriteria(Criteria.where(field).in(list));
		List<Dealer> matchDealers = mongoTemplate.find(query, Dealer.class);

		return matchDealers;

	}

}
