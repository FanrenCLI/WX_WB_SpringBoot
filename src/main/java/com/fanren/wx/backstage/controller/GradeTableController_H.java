package com.fanren.wx.backstage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.dao.ClassMapper;
import com.fanren.wx.app.dao.CurriculumMapper;
import com.fanren.wx.app.dao.MajorMapper;
import com.fanren.wx.app.dao.StudentMapper;
import com.fanren.wx.app.pojo.Class;
import com.fanren.wx.app.pojo.*;
import com.fanren.wx.backstage.service.CollegeService_H;
import com.fanren.wx.backstage.service.MajorService_H;
import com.fanren.wx.backstage.service.TeacherService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @Author: FanrenCLI
 * @Date: 2019/3/1 13:17
 * @Description: Class
 * @version:
 */
@RestController
public class GradeTableController_H {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    CollegeService_H collegeService_h;
    @Autowired
    MajorMapper majorMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    MajorService_H majorService_h;
    @Autowired
    TeacherService_H teacherService_H;
    @Autowired
    CurriculumMapper curriculumMapper;
    @Autowired
    StudentMapper studentMapper;

    @GetMapping(value = "/bin/grade")
    public String getStuGradeById(String id){
        String collection=id.substring(0,7);
        Query query=new Query(Criteria.where("stuid").is(id));
        Query query1=new Query(Criteria.where("name").is("curriculum"));
        String curr=mongoTemplate.find(query1,String.class,collection).get(0);
        String result=mongoTemplate.find(query,String.class,collection).get(0);
        //String result=mongoTemplate.findAll(String.class,collection).get(0);
        String info="{\"curr\":"+curr+",\"grade\":"+result+"}";
        return info;
    }

    @RequestMapping("/bin/GetCollege_grade")
    public List<College> GetCollege(){
        return collegeService_h.college_list();
    }

    @RequestMapping("/bin/GetMajor_grade")
    public List<Major> GetMajor(String id){
        MajorExample majorExample = new MajorExample();
        MajorExample.Criteria criteria = majorExample.createCriteria();
        criteria.andCollegeIdEqualTo(id);
        return majorMapper.selectByExample(majorExample);
    }

    @RequestMapping("/bin/GetClass_grade")
    public List<Class> Getclass(String id){
        ClassExample classExample = new ClassExample();
        ClassExample.Criteria criteria = classExample.createCriteria();
        criteria.andMajorIdEqualTo(id);
        return classMapper.selectByExample(classExample);
    }

    @RequestMapping("/bin/GetGrade")
    @ResponseBody
    public String GetGrade(String data){
        JSONObject info = JSONObject.parseObject(data);
        String collection = info.getString("nianji")+info.getString("yuanxi")+info.getString("zhuanye");
        Query query1=new Query(Criteria.where("name").is("curriculum"));
        String curr=mongoTemplate.find(query1,String.class,collection).get(0);
        List<String> grades =  mongoTemplate.findAll(String.class,collection);
        return "{\"curr\":"+curr+",\"grade\":"+grades+"}";
    }

    @RequestMapping("/bin/GetCurr")
    public String GetCurr(String id){
        String collection=id.substring(0,7);
        Query query=new Query(Criteria.where("name").is("curriculum"));
        String curr=mongoTemplate.find(query,String.class,collection).get(0);
        return curr;
    }

    @RequestMapping("/bin/grade_insert")
    public void grade_insert(String data){
        JSONObject info = JSONObject.parseObject(data);
        String collection=info.getString("stuid").substring(0,7);
        mongoTemplate.insert(data,collection);
    }

    @RequestMapping("/bin/grade_delete")
    public void grade_delete(String data){
        JSONObject info = JSONObject.parseObject(data);
        String collection=info.getString("stuid").substring(0,7);
        Query query = Query.query(Criteria.where("stuid").is(info.getString("stuid")));
        mongoTemplate.remove(query,collection);
    }

    @RequestMapping("/bin/grade_update")
    public void grade_update(String data){
        //将字符串转json
        JSONObject info = JSONObject.parseObject(data);
        //获取更新集合
        String collection=info.getString("stuid").substring(0,7);
        //设置更新条件
        Query query = new Query();
        query.addCriteria(Criteria.where("stuid").is(info.getString("stuid")));
        //设置更新数据
        Update update = new Update();
        for (Map.Entry<String,Object> entry:info.entrySet()){
            if (entry.getValue().equals("")==false){
                update.set(entry.getKey(),entry.getValue());
            }
        }
        mongoTemplate.updateMulti(query,update,collection);

    }

    @RequestMapping("/bin/GetCurriculum_grade")
    public List<Curriculum> GetCurriculum(String id){
        String teacher_name = teacherService_H.GetTeacher(id).getName();
        CurriculumExample curriculumExample = new CurriculumExample();
        CurriculumExample.Criteria criteria = curriculumExample.createCriteria();
        criteria.andTeachersEqualTo(teacher_name);
        return curriculumMapper.selectByExample(curriculumExample);
    }

    @RequestMapping("/bin/GetStudent_grade")
    public List<Student> GetStudent(String classname){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andClassesEqualTo(classname);
        return studentMapper.selectByExample(studentExample);
    }

    @RequestMapping("/bin/input_grade")
    public void input_grade(String grade,String curr){
        //将成绩封装成json对象
        JSONArray jsonGrade = JSONArray.parseArray(grade);
        //定位操作的集合
        String collection = ((JSONObject)jsonGrade.get(0)).getString("studentId").substring(0,7);
        //查询成绩表中的课程
        Query querycurr = new Query(Criteria.where("name").is("curriculum"));
        JSONObject json_curr = mongoTemplate.find(querycurr,JSONObject.class,collection).get(0);
        String curr_ID = null;
        //找到指定课程名的ID
        for (Map.Entry<String,Object> entry:json_curr.entrySet()){
            if (entry.getValue().equals(curr)){
                curr_ID = entry.getKey();
            }
        }
        //遍历学生成绩进行添加
        for (int i=0;i<jsonGrade.size();i++){
            JSONObject json = (JSONObject) jsonGrade.get(i);
            Query query = new Query(Criteria.where("stuid").is(json.getString("studentId")));
            Update update = new Update();
            update.set("stuid",json.get("studentId"));
            update.set("name",json.get("name"));
            update.set(curr_ID,json.get("normal"));
            update.set(curr_ID+"_1",json.get("exam"));
            update.set(curr_ID+"_2",json.get("sum"));
            mongoTemplate.upsert(query,update,collection);
        }
    }

}
