package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.User;
import com.fanren.wx.backstage.service.UserService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController_H {
    @Autowired
    UserService_H userService_H;
    @RequestMapping("/H_login")
    @ResponseBody
    public String user_login(User user){
        boolean flag = false;
        flag = userService_H.CheckUser(user);
        if(flag==true){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/bin/user_list")
    @ResponseBody
    public List<User> user_list(){
        List<User> users = userService_H.get_user_list();
        return users;
    }

    @RequestMapping("/bin/user_number")
    @ResponseBody
    public int queryUserCount(){
        return userService_H.queryUserCount();
    }

    @RequestMapping("/bin/GetUser")
    @ResponseBody
    public User GetUser(String id){
        return userService_H.GetUser(id);
    }

    @RequestMapping("/bin/user_delete")
    @ResponseBody
    public void user_delete(String id){
        userService_H.user_delete(id);
    }

    @RequestMapping("/bin/user_insert")
    @ResponseBody
    public void user_insert(@RequestParam("file")MultipartFile file,User user){
        userService_H.user_insert(file,user);
    }

    @RequestMapping("/bin/user_update")
    @ResponseBody
    public void user_update(@RequestParam(value = "file",required = false)MultipartFile file,User user){
        if (!file.isEmpty()){
            userService_H.user_update(file,user);
        }else {
            userService_H.user_update(user);
        }
    }


}
