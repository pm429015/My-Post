package org.nedesona.service;

import java.util.List;

import org.nedesona.domain.Article;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;

public interface PostManager {

	void savePost(Post post);

	List<Post> getPostList();
	
	Post viewById(String id);
	
	void addDeal(Deal deal);
	
	List<Post> search(String keyword);

	void updateDeal(Deal forWhichDeal);
	
	void updatePost(String id, String field, String value);

}
