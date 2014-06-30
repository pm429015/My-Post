package org.nedesona.dao.impl;


import org.nedesona.dao.DealDao;
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
public class DealDaoImpl implements DealDao {

	@Autowired(required = false)
	private MongoTemplate mongoTemplate;

	@Override
	public void saveDeal(Deal deal) {
		mongoTemplate.save(deal);
	}

	@Override
	public Deal viewById(String id) {
		// TODO Auto-generated method stub
		
		return mongoTemplate.findById(id, Deal.class);
	}

	@Override
	public Deal searchBy(String by, String term) {
		Query query = new Query();
		query.addCriteria(Criteria.where(by).is(term));
		Deal returnDeal = mongoTemplate.findOne(query, Deal.class);
		if (returnDeal == null) {
			// return null if doesn't exist
			return null;
		}else{
			return returnDeal;
		}
	}

	@Override
	public void addComment(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, Deal.class);
	}
}
