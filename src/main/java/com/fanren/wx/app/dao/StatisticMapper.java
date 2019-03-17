package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Statistic;
import com.fanren.wx.app.pojo.StatisticExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticMapper {
    long countByExample(StatisticExample example);

    int deleteByExample(StatisticExample example);

    int insert(Statistic record);

    int insertSelective(Statistic record);

    List<Statistic> selectByExample(StatisticExample example);

    int updateByExampleSelective(@Param("record") Statistic record, @Param("example") StatisticExample example);

    int updateByExample(@Param("record") Statistic record, @Param("example") StatisticExample example);
}