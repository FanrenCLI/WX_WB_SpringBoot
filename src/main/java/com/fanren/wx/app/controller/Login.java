package com.fanren.wx.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.pojo.LoginBackEntity;
import com.fanren.wx.app.pojo.User;
import com.fanren.wx.app.serivce.UserService;
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
    private UserService userService;


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
        if(id==null&&pwd==null){
            String openid=jsonObject.getString("openid");
            List<User> result= userService.checkOpenIdExist(openid);
            LoginBackEntity entity=new LoginBackEntity();
            if(!result.isEmpty()){
                entity.setStatus_1("false");
                return entity;
            }else{
                //此处修改！！！！！！！！！！！！！！！！！！
                User user=result.get(0);
                entity.setId(user.getUserId());
                entity.setStatus_1("true");



                return entity;
            }
        }else {
            boolean flag = userService.checkUserInfo(id,pwd);
            if(!flag){
                boolean openidExist=userService.checkOpenIdInfo(id,pwd);
                if(!openidExist){
                    userService.bindWXInfo(id,pwd,jsonObject.getString("openid"));
                }
            }else{

            }
        }
        return null;
    }



}
