package com.joseph.osys.pojos;

public class Chapter {
    private Integer chapterid;

    private String chaptername;

    private Integer chapternameid;

    private Integer bookid;

    private String videourl;

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername == null ? null : chaptername.trim();
    }

    public Integer getChapternameid() {
        return chapternameid;
    }

    public void setChapternameid(Integer chapternameid) {
        this.chapternameid = chapternameid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }
}