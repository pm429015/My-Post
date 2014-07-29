package org.nedesona.dao.impl;

import java.util.List;

import org.nedesona.dao.PostDao;
import org.nedesona.dao.ZipDao;
import org.nedesona.domain.Dealer;
import org.nedesona.domain.Post;
import org.nedesona.domain.Zip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ZipDaoImpl implements ZipDao {

	@Autowired(required = false)
	private MongoTemplate mongoTemplate;

	@Override
	public Zip findByZip(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("zipCode").is(id));
		Zip zip = mongoTemplate.findOne(query, Zip.class);
		
		return zip;
	}

	@Override
	public List<Zip> searchZips(double maxLat, double minLat, double maxLon, double minLon) {
//		String query = "{$and:[  {latitude:{$gt:\""+minLat+"\"}},  {longitude:{$gt:\""+minLon+"\"}}, "
//							   + "{latitude:{$lt:\""+maxLat+"\"}},  {longitude:{$lt:\""+maxLon+"\"}}     ]}";
		
		Query query = new Query();
		query.addCriteria(
			Criteria.where("latitude").exists(true)
			.andOperator(
						Criteria.where("latitude").gt(minLat),
		                Criteria.where("latitude").lt(maxLat),
		                Criteria.where("longitude").gt(minLon),
		                Criteria.where("longitude").lt(maxLon)
			)
		);
		return  mongoTemplate.find(query, Zip.class);
	}
}
