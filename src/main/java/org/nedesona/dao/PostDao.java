package org.nedesona.dao;

import java.util.List;

import org.nedesona.domain.Article;
import org.nedesona.domain.Post;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface PostDao {

	void savePost(Post post);

	List<Post> getPostList();
	
	Post viewById(String id); 
	
	void addDeal(Query query, Update update);
}
