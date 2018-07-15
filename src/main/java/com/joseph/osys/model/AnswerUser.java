package com.joseph.osys.model;

import com.joseph.osys.pojos.Questionanswer;
import com.joseph.osys.pojos.User;

public class AnswerUser {
	private Questionanswer answer;
	private User user;
	public AnswerUser() {
		super();
	}
	public AnswerUser(Questionanswer answer, User user) {
		super();
		this.answer = answer;
		this.user = user;
	}
	public Questionanswer getAnswer() {
		return answer;
	}
	public void setAnswer(Questionanswer answer) {
		this.answer = answer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
