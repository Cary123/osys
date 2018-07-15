package com.joseph.osys.pojos;

public class Sector {
    private Integer sectorid;

    private String sectorname;

    private Integer chapterid;

    private String pdfurl;

    private Integer sectornameid;

    public Integer getSectorid() {
        return sectorid;
    }

    public void setSectorid(Integer sectorid) {
        this.sectorid = sectorid;
    }

    public String getSectorname() {
        return sectorname;
    }

    public void setSectorname(String sectorname) {
        this.sectorname = sectorname == null ? null : sectorname.trim();
    }

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl == null ? null : pdfurl.trim();
    }

    public Integer getSectornameid() {
        return sectornameid;
    }

    public void setSectornameid(Integer sectornameid) {
        this.sectornameid = sectornameid;
    }
}