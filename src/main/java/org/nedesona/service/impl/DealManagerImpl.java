package org.nedesona.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.nedesona.dao.ArticleDao;
import org.nedesona.dao.DealDao;
import org.nedesona.dao.PostDao;
import org.nedesona.domain.Article;
import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;
import org.nedesona.service.ArticleManager;
import org.nedesona.service.DealManager;
import org.nedesona.service.PostManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DealManagerImpl implements DealManager {

	@Autowired
	private DealDao dealDao;

	@Override
	public void saveDeal(Deal deal) {
		Date timeStamp = Calendar.getInstance().getTime();
		deal.setCreateDate(timeStamp);
		deal.setLastModifiedDate(timeStamp);
		deal.setViewCount(0);
		dealDao.saveDeal(deal);

	}

	@Override
	public Deal viewById(String id) {
		// TODO Auto-generated method stub
		return dealDao.viewById(id);
	}

	@Override
	public Deal searchBy(String by, String term) {
		// TODO Auto-generated method stub
		return dealDao.searchBy(by, term);
	}

	@Override
	public void addComment(Comment comment) {
		Query query = new Query(Criteria.where("id").is(
				comment.getDeal().getId()));
		Update updateQuery = new Update().set("comments." + comment.getId(),comment);
		dealDao.addComment(query, updateQuery);

	}

}
