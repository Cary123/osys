package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Booknote;
import com.joseph.osys.pojos.BooknoteExample;

public interface BooknoteMapper {
    int countByExample(BooknoteExample example);

    int deleteByExample(BooknoteExample example);

    int deleteByPrimaryKey(Integer noteid);

    int insert(Booknote record);

    int insertSelective(Booknote record);

    List<Booknote> selectByExampleWithBLOBs(BooknoteExample example);

    List<Booknote> selectByExample(BooknoteExample example);

    Booknote selectByPrimaryKey(Integer noteid);

    int updateByExampleSelective(@Param("record") Booknote record, @Param("example") BooknoteExample example);

    int updateByExampleWithBLOBs(@Param("record") Booknote record, @Param("example") BooknoteExample example);

    int updateByExample(@Param("record") Booknote record, @Param("example") BooknoteExample example);

    int updateByPrimaryKeySelective(Booknote record);

    int updateByPrimaryKeyWithBLOBs(Booknote record);

    int updateByPrimaryKey(Booknote record);
}