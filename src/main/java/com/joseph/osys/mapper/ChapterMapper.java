package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Chapter;
import com.joseph.osys.pojos.ChapterExample;

public interface ChapterMapper {
    int countByExample(ChapterExample example);

    int deleteByExample(ChapterExample example);

    int deleteByPrimaryKey(Integer chapterid);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    List<Chapter> selectByExample(ChapterExample example);

    Chapter selectByPrimaryKey(Integer chapterid);

    int updateByExampleSelective(@Param("record") Chapter record, @Param("example") ChapterExample example);

    int updateByExample(@Param("record") Chapter record, @Param("example") ChapterExample example);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
    
    Chapter selectByBookAndId(Integer bookId, Integer chapterNameId);
}