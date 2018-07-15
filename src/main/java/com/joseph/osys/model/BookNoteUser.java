package com.joseph.osys.model;

import com.joseph.osys.pojos.Booknote;
import com.joseph.osys.pojos.User;

public class BookNoteUser {
	private Booknote booknote;
	private User user;
	public BookNoteUser() {
		super();
	}
	public BookNoteUser(Booknote booknote, User user) {
		super();
		this.booknote = booknote;
		this.user = user;
	}
	public Booknote getBooknote() {
		return booknote;
	}
	public void setBooknote(Booknote booknote) {
		this.booknote = booknote;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
