package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Inform;
import com.fanren.wx.backstage.service.InformService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class InformController_H {
    @Autowired
    InformService_H informService_H;

    @RequestMapping("/bin/inform_list")
    @ResponseBody
    public List<Inform> inform_list(){
        return informService_H.inform_list();
    }

    @RequestMapping("/bin/inform_insert")
    @ResponseBody
    public void inform_insert(@RequestParam(value = "file",required = false)MultipartFile file,Inform inform){
        if(file.isEmpty()==true){
            informService_H.inform_insert(inform);
        }else {
            informService_H.inform_insert(file,inform);
        }
    }

    @RequestMapping("/bin/GetInform")
    @ResponseBody
    public Inform GetInform(String title){
        return informService_H.GetInform(title);
    }

    @RequestMapping("/bin/annex_download")
    @ResponseBody
    public void annex_download(String title, HttpServletResponse response)throws UnsupportedEncodingException {
        informService_H.annex_download(title,response);
    }

    @RequestMapping("/bin/inform_delete")
    @ResponseBody
    public void inform_delete(String title){
        informService_H.inform_delete(title);
    }

    @RequestMapping("/bin/inform_update")
    @ResponseBody
    public void inform_update(@RequestParam(value = "file",required = false)MultipartFile file,Inform inform){
        if(file.isEmpty()==true){
            informService_H.inform_update(inform);
        }else {
            informService_H.inform_update(file,inform);
        }
    }

    @RequestMapping("/bin/inform_number")
    @ResponseBody
    public long inform_number(){
        return informService_H.inform_number();
    }
}
