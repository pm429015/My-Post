package org.nedesona.service.impl;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.nedesona.dao.DealerDao;
import org.nedesona.dao.UserDao;
import org.nedesona.domain.Dealer;
import org.nedesona.domain.Post;
import org.nedesona.domain.User;
import org.nedesona.service.DealerManager;
import org.nedesona.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DealerManagerImpl implements DealerManager {

	@Autowired
	private DealerDao dealerdao;

	@Override
	public void addDealer(Dealer dealer) {
		// Add the user if not exist
		if (!dealerdao.checkDealerExist(dealer)) {
			dealerdao.addNewDealer(dealer);
		}
	}

	@Override
	public List<Dealer> searchDealers(String field, List<String> list)  {
		List<Dealer> dealers = dealerdao.searchDealers(field, list);
		return dealers;
	}

}
