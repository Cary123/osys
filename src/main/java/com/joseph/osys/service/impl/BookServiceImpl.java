package com.joseph.osys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.joseph.osys.mapper.BookMapper;
import com.joseph.osys.mapper.ChapterMapper;
import com.joseph.osys.mapper.SectorMapper;
import com.joseph.osys.model.BookDetail;
import com.joseph.osys.model.ChapterDetail;
import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.Chapter;
import com.joseph.osys.pojos.ChapterExample;
import com.joseph.osys.pojos.SectorExample;
import com.joseph.osys.pojos.ChapterExample.Criteria;
import com.joseph.osys.pojos.Sector;
import com.joseph.osys.service.BookService;

public class BookServiceImpl implements BookService{

	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private SectorMapper sectorMapper;
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	public BookDetail getBookDetail(Integer bookId) {
		BookDetail bookDetail = new BookDetail();
		List<ChapterDetail> chapterDetails = new ArrayList<ChapterDetail>();
		Book book = bookMapper.selectByPrimaryKey(bookId);
		ChapterExample chapterExample = new ChapterExample();
		Criteria chapterCriteria = chapterExample.createCriteria();
		
		chapterExample.setOrderByClause("chapternameid asc");
		chapterCriteria.andBookidEqualTo(book.getBookid());
		List<Chapter> chapters= chapterMapper.selectByExample(chapterExample);
		for (Chapter chapter : chapters) {
			ChapterDetail chapterDetail = new ChapterDetail();
			SectorExample sectorExample = new SectorExample();
			sectorExample.setOrderByClause("sectornameid asc");
			com.joseph.osys.pojos.SectorExample.Criteria sectorCriteria = sectorExample.createCriteria();
			sectorCriteria.andChapteridEqualTo(chapter.getChapterid());
			List<Sector> sectors= sectorMapper.selectByExample(sectorExample);
			chapterDetail.setChapter(chapter);
			chapterDetail.setSectors(sectors);
			chapterDetails.add(chapterDetail);
		}
		bookDetail.setBook(book);
		bookDetail.setChapters(chapterDetails);
		return bookDetail;
	}

}
