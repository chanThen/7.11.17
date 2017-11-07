package com.BookWorld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_Review")
public class BookReview {
	
	@Id
	@GeneratedValue
	@Column(name="bookReviewId")
	private int bookReviewId;
	
	@Column(name="bookId")
	private int bookId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="bookComment")
	private String bookComment;
	
	@Column(name="bookRating")
	private int bookRating;
	
	@Column(name="name")
	private String name;

	public int getBookReviewId() {
		return bookReviewId;
	}

	public void setBookReviewId(int bookReviewId) {
		this.bookReviewId = bookReviewId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookComment() {
		return bookComment;
	}

	public void setBookComment(String bookComment) {
		this.bookComment = bookComment;
	}

	public int getBookRating() {
		return bookRating;
	}

	public void setBookRating(int bookRating) {
		this.bookRating = bookRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
