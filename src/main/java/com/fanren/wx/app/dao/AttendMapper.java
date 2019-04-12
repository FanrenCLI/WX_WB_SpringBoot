package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Attend;
import com.fanren.wx.app.pojo.AttendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendMapper {
    long countByExample(AttendExample example);

    int deleteByExample(AttendExample example);

    int insert(Attend record);

    int insertSelective(Attend record);

    List<Attend> selectByExample(AttendExample example);

    int updateByExampleSelective(@Param("record") Attend record, @Param("example") AttendExample example);

    int updateByExample(@Param("record") Attend record, @Param("example") AttendExample example);
}