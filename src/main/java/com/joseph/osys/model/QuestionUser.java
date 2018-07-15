package com.joseph.osys.model;

import com.joseph.osys.pojos.Question;
import com.joseph.osys.pojos.Questionanswer;
import com.joseph.osys.pojos.User;

public class QuestionUser {
	private Question question;
	private User user;
	private Questionanswer answer;
	public QuestionUser() {
		super();
	}
	public QuestionUser(Question question, User user, Questionanswer answer) {
		super();
		this.question = question;
		this.user = user;
		this.answer = answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Questionanswer getAnswer() {
		return answer;
	}
	public void setAnswer(Questionanswer answer) {
		this.answer = answer;
	}
	
}
