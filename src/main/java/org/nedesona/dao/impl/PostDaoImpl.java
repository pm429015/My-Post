package org.nedesona.dao.impl;

import java.util.List;

import org.nedesona.dao.ArticleDao;
import org.nedesona.dao.PostDao;
import org.nedesona.domain.Article;
import org.nedesona.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired(required = false)
	private MongoTemplate mongoTemplate;

	@Override
	public void savePost(Post post) {
		mongoTemplate.save(post);
	}

	@Override
	public List<Post> getPostList() {
		return mongoTemplate.findAll(Post.class);
	}

	@Override
	public Post viewById(String id) {
		// TODO Auto-generated method stub
		
		return mongoTemplate.findById(id, Post.class);
	}

	@Override
	public void addDeal(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, Post.class);
	}
}
