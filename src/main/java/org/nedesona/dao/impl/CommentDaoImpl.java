package org.nedesona.dao.impl;


import org.nedesona.dao.CommentDao;
import org.nedesona.dao.DealDao;
import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired(required = false)
	private MongoTemplate mongoTemplate;

	@Override
	public Comment viewById(String id) {
		// TODO Auto-generated method stub
		
		return mongoTemplate.findById(id, Comment.class);
	}

	@Override
	public void saveComment(Comment comment) {
		mongoTemplate.save(comment);
	}
}
