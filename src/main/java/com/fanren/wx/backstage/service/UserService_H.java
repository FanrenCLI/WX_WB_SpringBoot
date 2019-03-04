package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.UserMapper;
import com.fanren.wx.app.pojo.User;
import com.fanren.wx.app.pojo.UserExample;
import com.fanren.wx.backstage.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class UserService_H {
    @Autowired
    UserMapper userMapper;
    public boolean CheckUser(User user){
        boolean flag = false;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        List<User> users = userMapper.selectByExample(userExample);
        for(User u:users){
            if(user.getPwd().equals(u.getPwd()) && "admin".equals(u.getRole())){
                flag=true;
            }
        }
        return flag;
    }
    public List<User> get_user_list(){
        UserExample example=new UserExample();
        return userMapper.selectByExample(example);
    }
    public long queryUserCount(){

        UserExample example=new UserExample();
        return userMapper.countByExample(example);
    }

    public User GetUser(String id){
        return userMapper.selectByPrimaryKey(id);
    }

    public void user_delete(String id){
        User user = GetUser(id);
        File file = new File(user.getPicture_dir());
        file.delete();
        userMapper.deleteByPrimaryKey(id);
    }

    public void user_insert(MultipartFile file,User user){
        List<String> liststr = FileUtil.fileupload(file);
        // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
        user.setPicture("http://localhost:8080/"+liststr.get(1));
        user.setPicture_dir(liststr.get(0).substring(1)+liststr.get(1));
        userMapper.insert(user);

    }

    public void user_update(MultipartFile file,User user){

    }

    public void user_update(User user){
    }

}
