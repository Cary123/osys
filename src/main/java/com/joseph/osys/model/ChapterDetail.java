package com.joseph.osys.model;

import java.util.List;

import com.joseph.osys.pojos.Chapter;
import com.joseph.osys.pojos.Sector;

public class ChapterDetail {
	private Chapter chapter;
	private List<Sector> sectors;
	public ChapterDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChapterDetail(Chapter chapter, List<Sector> sectors) {
		super();
		this.chapter = chapter;
		this.sectors = sectors;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public List<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
	
}
