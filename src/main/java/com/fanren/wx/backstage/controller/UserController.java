package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.User;
import com.fanren.wx.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/H_login")
    @ResponseBody
    public String user_login(User user){
        boolean flag = false;
        flag = userService.CheckUser(user);
        if(flag==true){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/bin/user_list")
    @ResponseBody
    public List<User> user_list(){
        List<User> users = userService.get_user_list();
        return users;
    }

    @RequestMapping("/bin/user_number")
    @ResponseBody
    public int queryUserCount(){
        return userService.queryUserCount();
    }

    @RequestMapping("/bin/GetUser")
    @ResponseBody
    public User GetUser(String id){
        return userService.GetUser(id);
    }

    @RequestMapping("/bin/user_delete")
    @ResponseBody
    public void user_delete(String id){
        userService.user_delete(id);
    }

    @RequestMapping("/bin/user_insert")
    @ResponseBody
    public void user_insert(@RequestParam("file")MultipartFile file,User user){
        userService.user_insert(file,user);
    }

    @RequestMapping("/bin/user_update")
    @ResponseBody
    public void user_update(@RequestParam(value = "file",required = false)MultipartFile file,User user){
        if (!file.isEmpty()){
            userService.user_update(file,user);
        }else {
            userService.user_update(user);
        }
    }


}
