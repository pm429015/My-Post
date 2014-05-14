package org.nedesona.dao;

import java.util.List;

import org.nedesona.domain.Deal;

public interface DealDao {

	void saveDeal(Deal deal);

	Deal viewById(String id); 
}
