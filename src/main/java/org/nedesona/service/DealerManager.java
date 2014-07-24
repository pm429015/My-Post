package org.nedesona.service;

import java.util.List;
import java.util.Map;

import org.nedesona.domain.BookmarkUser;
import org.nedesona.domain.Dealer;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;

public interface DealerManager {
	
	void addDealer(Dealer dealer);
	
	List<Dealer> searchDealers(String field, List<String> list) ;
	
	Dealer searchByID(String term);
	
	void update(Dealer dealer);
}
