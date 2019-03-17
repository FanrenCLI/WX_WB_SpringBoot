package com.fanren.wx.backstage.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.dao.UserMapper;
import com.fanren.wx.app.pojo.User;
import com.fanren.wx.app.pojo.UserExample;
import com.fanren.wx.backstage.util.FileUtil;
import com.fanren.wx.backstage.util.UpdateSelective;
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
            if(user.getPwd().equals(u.getPwd())){
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
        File file = new File(user.getPictureDir());
        file.delete();
        userMapper.deleteByPrimaryKey(id);
    }

    public void user_insert(MultipartFile file,User user){
        List<String> liststr = FileUtil.fileupload(file);
        // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
        user.setPicture("http://localhost:8080/"+liststr.get(1));
        user.setPictureDir(liststr.get(0).substring(1)+liststr.get(1));
        userMapper.insert(user);

    }

    public void user_update(MultipartFile file,User user) throws Exception {
        //删除源文件
        User u = GetUser(user.getUserId());
        if(u.getPictureDir()!=null){
            File oldfile = new File(u.getPictureDir());
            oldfile.delete();
        }
        //上传新文件
        List<String> strs = FileUtil.fileupload(file);
        user.setPicture("http://localhost:8080/"+strs.get(1));
        user.setPictureDir(strs.get(0).substring(1)+strs.get(1));
        //更新信息
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        User o = (User)UpdateSelective.selectiveFun(user);
        userMapper.updateByExampleSelective(o,userExample);
    }

    public void user_update(User user) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        User u = (User) UpdateSelective.selectiveFun(user);
        userMapper.updateByExampleSelective(u,userExample);
    }

    public void user_delete_many(String data){
        JSONArray jsonArray = JSONArray.parseArray(data);
        for (int i=0;i<jsonArray.size();i++){
            JSONObject json = (JSONObject) jsonArray.get(i);
            String id = json.getString("userId");
            user_delete(id);
        }
    }

}
