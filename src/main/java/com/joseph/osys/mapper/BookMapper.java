package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.BookExample;

public interface BookMapper {
    int countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookid);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExampleWithBLOBs(BookExample example);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer bookid);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKeyWithBLOBs(Book record);

    int updateByPrimaryKey(Book record);
}