package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Videonote;
import com.joseph.osys.pojos.VideonoteExample;

public interface VideonoteMapper {
    int countByExample(VideonoteExample example);

    int deleteByExample(VideonoteExample example);

    int deleteByPrimaryKey(Integer noteid);

    int insert(Videonote record);

    int insertSelective(Videonote record);

    List<Videonote> selectByExampleWithBLOBs(VideonoteExample example);

    List<Videonote> selectByExample(VideonoteExample example);

    Videonote selectByPrimaryKey(Integer noteid);

    int updateByExampleSelective(@Param("record") Videonote record, @Param("example") VideonoteExample example);

    int updateByExampleWithBLOBs(@Param("record") Videonote record, @Param("example") VideonoteExample example);

    int updateByExample(@Param("record") Videonote record, @Param("example") VideonoteExample example);

    int updateByPrimaryKeySelective(Videonote record);

    int updateByPrimaryKeyWithBLOBs(Videonote record);

    int updateByPrimaryKey(Videonote record);
}