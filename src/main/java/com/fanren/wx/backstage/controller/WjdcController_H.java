package com.fanren.wx.backstage.controller;

import com.fanren.wx.backstage.service.WjdcService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class WjdcController_H {
    @Autowired
    WjdcService_H wjdcService_H;

    @RequestMapping("/bin/wjdc_list")
    public String wjdcList(){
        return wjdcService_H.wjdcList();
    }

    @RequestMapping("/bin/Getwjdc")
    public String Getwjdc(String name){
        return wjdcService_H.Getwjdc(name);
    }

    @RequestMapping("/bin/wjdc_number")
    public long wjdc_number(){
        return wjdcService_H.wjdc_number();
    }

    @RequestMapping("/bin/wjdc_upload")
    public String wjdc_upload(@RequestParam("file") MultipartFile file, String auth) throws Exception {
        return wjdcService_H.wjdc_upload(file,auth);
    }

    @RequestMapping("/bin/wjdc_download")
    public void wjdc_download(String name, HttpServletResponse response) throws IOException {
        wjdcService_H.wjdc_download(name,response);
    }

    @RequestMapping("/bin/wjdc_delete")
    public void wjdc_delete(String name) throws IOException {
        wjdcService_H.wjdc_delete(name);
    }
}
