package org.nedesona.dao;

import java.util.List;

import org.nedesona.domain.Deal;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface DealDao {

	void saveDeal(Deal deal);

	Deal viewById(String id);

	Deal searchBy(String by, String term); 
	
	void addComment(Query query, Update update);
}
