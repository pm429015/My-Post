package org.nedesona.dao;

import java.util.List;
import java.util.Map;

import org.nedesona.domain.Dealer;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public interface DealerDao {

	void addNewDealer(Dealer dealer);
	
	Boolean checkDealerExist(Dealer dealer);
	
	List<Dealer> searchDealers(String field, List<String> list);
	
	Dealer searchByID(String id);
}
