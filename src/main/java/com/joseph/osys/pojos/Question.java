package com.joseph.osys.pojos;

import java.util.Date;

public class Question {
    private Integer questionid;

    private Date questiontime;

    private String creater;

    private String questioncontent;
    
 private int start;//设置分页开始  
    
    private int limit;//设置分页的每页的数量</strong>  
    
    private String keywords;
    
      
    public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getStart() {  
        return start;  
    }  
  
    public void setStart(int start) {  
        this.start = start;  
    }  
  
    public int getLimit() {  
        return limit;  
    }  
  
    public void setLimit(int limit) {  
        this.limit = limit;  
    }  

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Date getQuestiontime() {
        return questiontime;
    }

    public void setQuestiontime(Date questiontime) {
        this.questiontime = questiontime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent == null ? null : questioncontent.trim();
    }
}