package com.fanren.wx.Service;

import com.fanren.wx.Dao.UserMapper;
import com.fanren.wx.Pojo.User;
import com.fanren.wx.Pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public boolean checkUser(User user){
        boolean check = false;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        for(User u:users){
            if (u.getPassword().equals(user.getPassword()) && "admin".equals(u.getRole())){
                return true;
            }
        }
        return check;
    }
}
