package com.fanren.wx.backstage.controller;

import com.fanren.wx.backstage.service.JxkpService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class JxkpController_H {
    @Autowired
    JxkpService_H jxkpService_H;

    @RequestMapping("/bin/jxkp_list")
    public String jxkpList(){
        return jxkpService_H.jxkpList();
    }

    @RequestMapping("/bin/Getjxkp")
    public String Getjxkp(String name){
        return jxkpService_H.Getjxkp(name);
    }

    @RequestMapping("/bin/jxkp_number")
    public long jxkp_number(){
        return jxkpService_H.jxkp_number();
    }

    @RequestMapping("/bin/jxkp_upload")
    public String jxkp_upload(@RequestParam("file") MultipartFile file) throws Exception {
        return jxkpService_H.jxkp_upload(file);
    }

    @RequestMapping("/bin/jxkp_download")
    public void jxkp_download(String name, HttpServletResponse response) throws IOException {
        jxkpService_H.jxkp_download(name,response);
    }

    @RequestMapping("/bin/jxkp_delete")
    public void jxkp_delete(String name) throws IOException {
        jxkpService_H.jxkp_delete(name);
    }
}
