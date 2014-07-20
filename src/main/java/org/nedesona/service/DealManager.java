package org.nedesona.service;

import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;

public interface DealManager {

	void saveDeal(Deal deal);
	
	void updateDeal(String id, String field, String value);
	
	Deal viewById(String id);
	
	Deal searchBy(String by, String term);
	
	void addComment(Comment comment);

}
