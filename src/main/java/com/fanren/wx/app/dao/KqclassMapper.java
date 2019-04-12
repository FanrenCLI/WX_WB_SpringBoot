package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Kqclass;
import com.fanren.wx.app.pojo.KqclassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KqclassMapper {
    long countByExample(KqclassExample example);

    int deleteByExample(KqclassExample example);

    int insert(Kqclass record);

    int insertSelective(Kqclass record);

    List<Kqclass> selectByExample(KqclassExample example);

    int updateByExampleSelective(@Param("record") Kqclass record, @Param("example") KqclassExample example);

    int updateByExample(@Param("record") Kqclass record, @Param("example") KqclassExample example);
}