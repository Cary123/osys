package com.joseph.osys.service;
import java.util.List;

import com.joseph.osys.pojos.Book;

public interface CourseService{
   public int addCourse(Book course);
   public List<Book> listCourse();
}
