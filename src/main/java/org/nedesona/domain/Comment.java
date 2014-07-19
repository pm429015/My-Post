package org.nedesona.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {
	@Id
	private String id;
	private String content;
	
	private Date createdDate;
	private Date lastModifiedDate;

	@DBRef
	private Object user;
	private Deal deal;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(User createdBy) {
		this.user = createdBy;
	}
	
	public void setUser(Dealer createdBy) {
		this.user = createdBy;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifyDate) {
		this.lastModifiedDate = lastModifyDate;
	}


}
