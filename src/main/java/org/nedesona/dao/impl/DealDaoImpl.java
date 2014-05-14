package org.nedesona.dao.impl;


import org.nedesona.dao.DealDao;
import org.nedesona.domain.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
}
