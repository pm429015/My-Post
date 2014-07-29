package org.nedesona.dao.impl;

import java.util.List;

import org.nedesona.dao.PostDao;
import org.nedesona.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
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
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "lastModifiedDate"));
		List<Post> resourceList = mongoTemplate.find(query, Post.class);
		
//		return mongoTemplate.findAll(Post.class);
		return resourceList;
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

	@Override
	public List<Post> search(String keyword) {
		String query = "{$or:[{description:{$regex:\""+keyword+"\", $options:\"i\"}},{title:{$regex:\""+keyword+"\",$options:\"i\"}}]}";
		BasicQuery searchbyKeyword = new BasicQuery(query);
		
		return  mongoTemplate.find(searchbyKeyword, Post.class);
		
	}
}
