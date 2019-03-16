package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Templist;
import com.fanren.wx.app.pojo.TemplistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplistMapper {
    long countByExample(TemplistExample example);

    int deleteByExample(TemplistExample example);

    int insert(Templist record);

    int insertSelective(Templist record);

    List<Templist> selectByExample(TemplistExample example);

    int updateByExampleSelective(@Param("record") Templist record, @Param("example") TemplistExample example);

    int updateByExample(@Param("record") Templist record, @Param("example") TemplistExample example);
}