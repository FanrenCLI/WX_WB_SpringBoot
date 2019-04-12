package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Exam;
import com.fanren.wx.app.pojo.ExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamMapper {
    List<Exam> getExamInfoByClasses(String classes);

    long countByExample(ExamExample example);

    int deleteByExample(ExamExample example);

    int insert(Exam record);

    int insertSelective(Exam record);

    List<Exam> selectByExample(ExamExample example);

    int updateByExampleSelective(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByExample(@Param("record") Exam record, @Param("example") ExamExample example);
}