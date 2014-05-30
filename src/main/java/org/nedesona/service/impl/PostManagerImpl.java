package org.nedesona.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nedesona.dao.PostDao;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;
import org.nedesona.service.PostManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class PostManagerImpl implements PostManager {

	@Autowired
	private PostDao postDao;

	@Override
	public void savePost(Post post) {
		Date timeStamp = Calendar.getInstance().getTime();
		post.setCreateDate(timeStamp);
		post.setLastModifiedDate(timeStamp);
		post.setViewCount(0);
		Map<String, Deal> deals = new HashMap<String, Deal>();
		post.setDeals(deals);
		postDao.savePost(post);

	}

	@Override
	public List<Post> getPostList() {
		return postDao.getPostList();
	}

	@Override
	public Post viewById(String id) {
		// TODO Auto-generated method stub
		return postDao.viewById(id);
	}

	@Override	
	public void addDeal(Deal deal) {
		Query query = new Query(Criteria.where("id").is(deal.getRefPost()));
		Update updateQuery = new Update().set("deals." + deal.getId(),deal);
		postDao.addDeal(query, updateQuery);

	}

	@Override
	public List<Post> search(String keyword) {
		return postDao.search(keyword);
	}

}
