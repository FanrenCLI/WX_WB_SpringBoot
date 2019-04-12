package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.ExamMapper;
import com.fanren.wx.app.pojo.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/6 17:33
 * @Description: Class
 * @version:
 */
@Service
public class ExamService {

    @Autowired
    private ExamMapper examMapper;

    public List<Exam> getExamInfo(String Classid){
        return examMapper.getExamInfoByClasses(Classid);
    }
}
