package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.UserMapper;
import com.fanren.wx.app.pojo.User;
import com.fanren.wx.app.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/1/25 20:17
 * @Description: Class
 * @version:
 */

@Service
public class LJUserService {
    /**
     * 检验用户登录信息
     * @param id
     * @param pwd
     * @return
     */

    @Autowired
    private UserMapper usermapper;

    public boolean checkUserInfo(String id, String pwd) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(id).andPwdEqualTo(pwd);
        List<User> result=usermapper.selectByExample(example);
        return result.isEmpty();
    }
    public void bindWXInfo(String id,String pwd,String openid){
        UserExample example =new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(id).andPwdEqualTo(pwd);
        User user=new User();
        user.setOpenId(openid);
        usermapper.updateByExampleSelective(user,example);
    }
    public boolean checkOpenIdInfo(String id,String pwd){
        UserExample example=new UserExample();
        UserExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(id).andPwdEqualTo(pwd);
        List<User> result=usermapper.selectByExample(example);
        String openid = result.get(0).getOpenId();
        if(openid==null||openid.equals("")){
            return false;
        }else{
            return true;
        }
    }
    public List<User> checkOpenIdExist(String openid){
        UserExample example=new UserExample();
        UserExample.Criteria criteria= example.createCriteria();
        criteria.andOpenIdEqualTo(openid);
        List<User> result = usermapper.selectByExample(example);
        return result;
    }
}
