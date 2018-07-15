package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Questionanswer;
import com.joseph.osys.pojos.QuestionanswerExample;

public interface QuestionanswerMapper {
    int countByExample(QuestionanswerExample example);

    int deleteByExample(QuestionanswerExample example);

    int deleteByPrimaryKey(Integer answerid);

    int insert(Questionanswer record);

    int insertSelective(Questionanswer record);

    List<Questionanswer> selectByExampleWithBLOBs(QuestionanswerExample example);

    List<Questionanswer> selectByExample(QuestionanswerExample example);

    Questionanswer selectByPrimaryKey(Integer answerid);

    int updateByExampleSelective(@Param("record") Questionanswer record, @Param("example") QuestionanswerExample example);

    int updateByExampleWithBLOBs(@Param("record") Questionanswer record, @Param("example") QuestionanswerExample example);

    int updateByExample(@Param("record") Questionanswer record, @Param("example") QuestionanswerExample example);

    int updateByPrimaryKeySelective(Questionanswer record);

    int updateByPrimaryKeyWithBLOBs(Questionanswer record);

    int updateByPrimaryKey(Questionanswer record);
}