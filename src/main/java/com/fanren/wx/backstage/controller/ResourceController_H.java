package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Resource;
import com.fanren.wx.backstage.service.ResourceService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ResourceController_H {
    @Autowired
    ResourceService_H resourceService_H;

    @RequestMapping("/bin/resource_list")
    @ResponseBody
    public List<Resource> resource_list(){
        return resourceService_H.resource_list();
    }

    @RequestMapping("/bin/resource_upload")
    @ResponseBody
    public void resource_upload(@RequestParam("file")MultipartFile file,Resource resource){
        resourceService_H.resource_upload(file,resource);
    }

    @RequestMapping("/bin/resource_number")
    @ResponseBody
    public long resource_number(){
        return resourceService_H.resource_number();
    }

    @RequestMapping("/bin/GetResource")
    @ResponseBody
    public Resource GetResource(String name){
        return resourceService_H.GetResource(name);
    }

    @RequestMapping("/bin/resource_delete_ftp")
    @ResponseBody
    public void resource_delete(String name) throws IOException {
        resourceService_H.resource_delete_ftp(name);
    }

    @RequestMapping("/bin/resource_download_ftp")
    @ResponseBody
    public void resource_download_ftp(String name, HttpServletResponse response) throws IOException {
        resourceService_H.resource_download_ftp(name,response);
    }

    @RequestMapping("/bin/resource_upload_ftp")
    @ResponseBody
    public String resource_upload_ftp(@RequestParam("file")MultipartFile file,Resource resource) throws Exception {
        return resourceService_H.resource_upload_ftp(file,resource);
    }

}

