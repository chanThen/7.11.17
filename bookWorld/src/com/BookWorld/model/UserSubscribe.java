package com.BookWorld.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_subscribe")
public class UserSubscribe {
	
	@Id
	@GeneratedValue
	@Column(name="subscribeId")
	private int subscribeId;
	
	@Column(name="userId")
	private int userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId")
	BookDetail bookDetail;

	public int getSubscribeId() {
		return subscribeId;
	}

	public void setSubscribeId(int subscribeId) {
		this.subscribeId = subscribeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	

	
}
