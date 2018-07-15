package com.joseph.osys.model;

import com.joseph.osys.pojos.User;
import com.joseph.osys.pojos.Videonote;

public class VideoNoteUser {
	private Videonote videonote;
	private User user;
	public VideoNoteUser() {
		super();
	}
	public VideoNoteUser(Videonote videonote, User user) {
		super();
		this.videonote = videonote;
		this.user = user;
	}
	public Videonote getVideonote() {
		return videonote;
	}
	public void setVideonote(Videonote videonote) {
		this.videonote = videonote;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
