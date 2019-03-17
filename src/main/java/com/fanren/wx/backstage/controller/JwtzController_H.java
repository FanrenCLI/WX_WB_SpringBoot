package com.fanren.wx.backstage.controller;

import com.fanren.wx.backstage.service.JwtzService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class JwtzController_H {
    @Autowired
    JwtzService_H jwtzService_H;

    @RequestMapping("/bin/jwtz_list")
    public String jwtzList(){
        return jwtzService_H.jwtzList();
    }

    @RequestMapping("/bin/Getjwtz")
    public String Getjwtz(String name){
        return jwtzService_H.Getjwtz(name);
    }

    @RequestMapping("/bin/jwtz_number")
    public long jwtz_number(){
        return jwtzService_H.jwtz_number();
    }

    @RequestMapping("/bin/jwtz_upload")
    public String jwtz_upload(@RequestParam("file")MultipartFile file,String auth) throws Exception {
        return jwtzService_H.jwtz_upload(file,auth);
    }

    @RequestMapping("/bin/jwtz_download")
    public void jwtz_download(String name, HttpServletResponse response) throws IOException {
        jwtzService_H.jwtz_download(name,response);
    }

    @RequestMapping("/bin/jwtz_delete")
    public void jwtz_delete(String name) throws IOException {
        jwtzService_H.jwtz_delete(name);
    }
}
