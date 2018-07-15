package com.joseph.osys.model;

import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.Chapter;

public class BookVideo {
	private Book book;
	private Chapter chapter;
	public BookVideo() {
		super();
	}
	public BookVideo(Book book, Chapter chapter) {
		super();
		this.book = book;
		this.chapter = chapter;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	
}
