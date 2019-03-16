package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.ResourceMapper;
import com.fanren.wx.app.pojo.Resource;
import com.fanren.wx.app.pojo.ResourceExample;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/11 17:32
 * @Description: Class
 * @version:
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    public List<Resource> getResourceList(){
        return resourceMapper.selectByExample(null);
    }

    public List<Resource> searchResourceByInfo(String info){
        ResourceExample example=new ResourceExample();
        example.or().andUploaderNameLike(info);
        example.or().andResourceNameLike(info);
        return resourceMapper.selectByExample(example);
    }
}
