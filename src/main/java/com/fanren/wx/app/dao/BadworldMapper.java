package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Badworld;
import com.fanren.wx.app.pojo.BadworldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BadworldMapper {
    long countByExample(BadworldExample example);

    int deleteByExample(BadworldExample example);

    int insert(Badworld record);

    int insertSelective(Badworld record);

    List<Badworld> selectByExample(BadworldExample example);

    int updateByExampleSelective(@Param("record") Badworld record, @Param("example") BadworldExample example);

    int updateByExample(@Param("record") Badworld record, @Param("example") BadworldExample example);
}