package org.nedesona.dao;

import org.nedesona.domain.Comment;

public interface CommentDao {
	
	void saveComment(Comment comment);
	
	Comment viewById(String id);
}
