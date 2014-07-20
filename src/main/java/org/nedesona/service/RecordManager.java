package org.nedesona.service;

import org.nedesona.domain.Record;

public interface RecordManager {
	void saveTransaction(Record transaction);
	
	Record findById(String id);
	
	void updateTransaction(String id, String field, String value);
}
