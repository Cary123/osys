package com.joseph.osys.pojos;

import java.util.Date;

public class Note {
    private Integer noteid;

    private Date notetime;

    private Integer bookid;

    private String creater;

    private String notecontent;

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public Date getNotetime() {
        return notetime;
    }

    public void setNotetime(Date notetime) {
        this.notetime = notetime;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getNotecontent() {
        return notecontent;
    }

    public void setNotecontent(String notecontent) {
        this.notecontent = notecontent == null ? null : notecontent.trim();
    }
}