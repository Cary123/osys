package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Sector;
import com.joseph.osys.pojos.SectorExample;

public interface SectorMapper {
    int countByExample(SectorExample example);

    int deleteByExample(SectorExample example);

    int deleteByPrimaryKey(Integer sectorid);

    int insert(Sector record);

    int insertSelective(Sector record);

    List<Sector> selectByExample(SectorExample example);

    Sector selectByPrimaryKey(Integer sectorid);

    int updateByExampleSelective(@Param("record") Sector record, @Param("example") SectorExample example);

    int updateByExample(@Param("record") Sector record, @Param("example") SectorExample example);

    int updateByPrimaryKeySelective(Sector record);

    int updateByPrimaryKey(Sector record);
}