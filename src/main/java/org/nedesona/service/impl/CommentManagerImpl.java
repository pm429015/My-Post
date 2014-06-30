package org.nedesona.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.nedesona.dao.ArticleDao;
import org.nedesona.dao.CommentDao;
import org.nedesona.dao.DealDao;
import org.nedesona.dao.PostDao;
import org.nedesona.domain.Article;
import org.nedesona.domain.Comment;
import org.nedesona.domain.Deal;
import org.nedesona.domain.Post;
import org.nedesona.service.ArticleManager;
import org.nedesona.service.CommentManager;
import org.nedesona.service.DealManager;
import org.nedesona.service.PostManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentManagerImpl implements CommentManager {

	@Autowired
	private CommentDao commentDao;


	@Override
	public Comment viewById(String id) {
		// TODO Auto-generated method stub
		return commentDao.viewById(id);
	}

	@Override
	public void saveComment(Comment comment) {
		Date timeStamp = Calendar.getInstance().getTime();
		comment.setCreatedDate(timeStamp);
		comment.setLastModifiedDate(timeStamp);
		commentDao.saveComment(comment);
	}

}
