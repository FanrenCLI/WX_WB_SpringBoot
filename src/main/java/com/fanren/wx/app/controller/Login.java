package com.fanren.wx.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.pojo.LoginBackEntity;
import com.fanren.wx.app.pojo.Student;
import com.fanren.wx.app.pojo.User;
import com.fanren.wx.app.serivce.LJUserService;
import com.fanren.wx.app.serivce.StudentService;
import com.fanren.wx.app.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: FanrenCLI
 * @Date: 2019/1/24 14:59
 * @Description: Class
 * @version:
 */

@RestController
public class Login {

    @Autowired
    private LJUserService LJUserService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginBackEntity checkLoginInfo(@RequestParam(value = "id",required = false) String id,
                                 @RequestParam(value = "pwd",required = false) String pwd,
                                 @RequestParam(value = "code") String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wx3563eb654dd6f231");
        param.put("secret", "7d4484b369bcf3cc301bb9f7884c6a4a");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(url, param);
        JSONObject jsonObject=JSONObject.parseObject(wxResult);
        if(id==null||pwd==null||id.equals("")||pwd.equals("")){
            String openid=jsonObject.getString("openid");
            List<User> result= LJUserService.checkOpenIdExist(openid);
            LoginBackEntity entity=new LoginBackEntity();
            if(!result.isEmpty()){
                User user=result.get(0);
                entity.setId(user.getRole().equals("stu")?"学生":"老师");
                entity.setStatus_1("true");
                Student stu_info=studentService.selectStudentById(user.getUserId());
                entity.setClasses(stu_info.getClasses());
                entity.setDepartment(stu_info.getDepartment());
                entity.setMajor(stu_info.getMajor());
                entity.setName(stu_info.getName());
                entity.setQq(stu_info.getQq());
                entity.setSex(stu_info.getSex());
                entity.setStuid(stu_info.getStudentId());
                entity.setTel(stu_info.getPhone());
                entity.setWx(stu_info.getWx());
                return entity;
            }else{
                entity.setStatus_1("false");
                return entity;
            }
        }else {
            boolean flag = LJUserService.checkUserInfo(id,pwd);
            LoginBackEntity entity=new LoginBackEntity();
            if(!flag){
                boolean openidExist= LJUserService.checkOpenIdInfo(id,pwd);
                if(!openidExist){
                    LJUserService.bindWXInfo(id,pwd,jsonObject.getString("openid"));
                }
                Student stu_info=studentService.selectStudentById(id);
                List<User> result= LJUserService.checkOpenIdExist(jsonObject.getString("openid"));
                User user=result.get(0);
                entity.setId(user.getRole().equals("stu")?"学生":"老师");
                entity.setStatus_1("true");
                entity.setClasses(stu_info.getClasses());
                entity.setDepartment(stu_info.getDepartment());
                entity.setMajor(stu_info.getMajor());
                entity.setName(stu_info.getName());
                entity.setQq(stu_info.getQq());
                entity.setSex(stu_info.getSex());
                entity.setStuid(stu_info.getStudentId());
                entity.setTel(stu_info.getPhone());
                entity.setWx(stu_info.getWx());
                return entity;
            }else{
                entity.setStatus_1("false");
                return entity;
            }
        }

    }



}
