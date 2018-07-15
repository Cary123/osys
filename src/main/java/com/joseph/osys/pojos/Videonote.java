package com.joseph.osys.pojos;

import java.util.Date;

public class Videonote {
    private Integer noteid;

    private Date notetime;

    private Integer chapterid;

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

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
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