package org.nedesona.dao;

import org.nedesona.domain.Record;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface RecordDao {

	void saveTransaction(Record transaction);
	
	Record findById(String id);
	
	void updateTransaction(Query query, Update update);
}
