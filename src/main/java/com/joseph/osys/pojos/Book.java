package com.joseph.osys.pojos;

public class Book {
    private Integer bookid;

    private String bookname;

    private String bookimage;

    private String bookcreater;

    private String bookdescript;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage == null ? null : bookimage.trim();
    }

    public String getBookcreater() {
        return bookcreater;
    }

    public void setBookcreater(String bookcreater) {
        this.bookcreater = bookcreater == null ? null : bookcreater.trim();
    }

    public String getBookdescript() {
        return bookdescript;
    }

    public void setBookdescript(String bookdescript) {
        this.bookdescript = bookdescript == null ? null : bookdescript.trim();
    }
}