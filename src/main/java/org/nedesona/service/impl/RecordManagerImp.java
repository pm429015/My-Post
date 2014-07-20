package org.nedesona.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.nedesona.dao.RecordDao;
import org.nedesona.domain.Record;
import org.nedesona.service.RecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class RecordManagerImp implements RecordManager{
	@Autowired
	RecordDao transactionDao;

	@Override
	public void saveTransaction(Record transaction) {
		Date timeStamp = Calendar.getInstance(TimeZone.getTimeZone("EST")).getTime();
		transaction.setCreateDate(timeStamp);
		transaction.setLastModifiedDate(timeStamp);
		transactionDao.saveTransaction(transaction);
	}

	@Override
	public Record findById(String id) {
		// TODO Auto-generated method stub
		return transactionDao.findById(id);
	}

	@Override
	public void updateTransaction(String id, String field, String value) {
		Query query = new Query(Criteria.where("id").is(id));
		Update update = Update.update(field, value);
		transactionDao.updateTransaction(query, update);
	}
}
