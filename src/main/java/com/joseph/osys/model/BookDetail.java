package com.joseph.osys.model;

import java.util.List;

import com.joseph.osys.pojos.Book;

public class BookDetail {
	private Book book;
	private List<ChapterDetail> chapters;
	public BookDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDetail(Book book, List<ChapterDetail> chapters) {
		super();
		this.book = book;
		this.chapters = chapters;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<ChapterDetail> getChapters() {
		return chapters;
	}
	public void setChapters(List<ChapterDetail> chapters) {
		this.chapters = chapters;
	}
	
}
