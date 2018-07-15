package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Question;
import com.joseph.osys.pojos.QuestionExample;

public interface QuestionMapper {
    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer questionid);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExampleWithBLOBs(QuestionExample example);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer questionid);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKeyWithBLOBs(Question record);

    int updateByPrimaryKey(Question record);
}