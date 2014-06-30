package org.nedesona.service;

import java.util.List;

import org.nedesona.domain.Article;
import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;

public interface CommentManager {

	void saveComment(Comment comment);
	
	Comment viewById(String id);

}
