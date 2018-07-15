package com.joseph.osys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.joseph.osys.pojos.Note;
import com.joseph.osys.pojos.NoteExample;

public interface NoteMapper {
    int countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(Integer noteid);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExampleWithBLOBs(NoteExample example);

    List<Note> selectByExample(NoteExample example);

    Note selectByPrimaryKey(Integer noteid);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExampleWithBLOBs(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKeyWithBLOBs(Note record);

    int updateByPrimaryKey(Note record);
}