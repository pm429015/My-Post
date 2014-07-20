package org.nedesona.dao.impl;


import org.nedesona.dao.RecordDao;
import org.nedesona.domain.Post;
import org.nedesona.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class RecordDaoImpl implements RecordDao {

	@Autowired(required = false)
	private MongoTemplate mongoTemplate;

	@Override
	public void saveTransaction(Record transaction) {
		mongoTemplate.save(transaction);
	}

	@Override
	public Record findById(String id) {
		return mongoTemplate.findById(id, Record.class);
	}

	@Override
	public void updateTransaction(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, Record.class);
	}
}
