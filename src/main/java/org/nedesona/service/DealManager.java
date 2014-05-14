package org.nedesona.service;

import java.util.List;

import org.nedesona.domain.Article;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;

public interface DealManager {

	void saveDeal(Deal deal);

	
	Deal viewById(String id);

}
