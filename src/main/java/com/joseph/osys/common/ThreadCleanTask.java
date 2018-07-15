package com.joseph.osys.common;

import javax.servlet.http.HttpSession;

public class ThreadCleanTask implements Runnable{
	private HttpSession session;
	private String name;
	private int second;
	
	public ThreadCleanTask(HttpSession session, String name, int second){
		this.session = session;
		this.name = name;
		this.second = second;
	}
	
	public void run() {
		int time = second;
		while(time > 0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time--;
		}
		if(session != null){
			session.removeAttribute(name);
		}
	}

}
