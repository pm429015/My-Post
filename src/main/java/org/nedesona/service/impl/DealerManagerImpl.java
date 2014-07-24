package org.nedesona.service.impl;

import java.util.List;
import org.nedesona.dao.DealerDao;
import org.nedesona.domain.Dealer;
import org.nedesona.service.DealerManager;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Dealer searchByID(String term) {
		Dealer dealer = dealerdao.searchByID(term);
		return dealer;
	}

	@Override
	public void update(Dealer dealer) {
		dealerdao.update(dealer);
	}

}
