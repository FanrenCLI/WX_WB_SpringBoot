package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.StudentMapper;
import com.fanren.wx.app.pojo.Student;
import com.fanren.wx.app.pojo.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/4 17:16
 * @Description: Class
 * @version:
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    /** 刘浩你的方法写在上面 下面的方法我写！！！！！！！！！！！！！！！！！！！！！！
     * @Author: FanrenCLI
     * @Date: 19:43 2019/2/28
     * @param: null
     * @Description: Method
     */
    public Student selectStudentById(String id){
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria=studentExample.createCriteria();
        criteria.andStudentIdEqualTo(id);
        Student result=studentMapper.selectByExample(studentExample).get(0);
        return result;
    }
}
