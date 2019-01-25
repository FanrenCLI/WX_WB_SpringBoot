package com.fanren.wx.Controller;

import com.fanren.wx.Pojo.User;
import com.fanren.wx.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("login")
    public String login(User user){
        String str = "";
        boolean check = userService.checkUser(user);
        if(check==true){
            str="redirect:index.html";
            System.out.println("11");
        }else {
            str="redirect:fail.html";
        }
        return str;
    }
}
