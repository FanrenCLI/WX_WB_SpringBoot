package com.fanren.wx.backstage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.pojo.Badworld;
import com.fanren.wx.backstage.service.BadworldService;
import com.fanren.wx.backstage.util.FileUtil;
import com.fanren.wx.backstage.util.ImgCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Set;

@Controller
public class BadworldController {
    @Autowired
    BadworldService badworldService;

    @RequestMapping("/bin/badworld_list")
    @ResponseBody
    public Set<String> badworld_list(){
        return badworldService.badworld_list_string();
    }

    @RequestMapping("/bin/badworld_number")
    @ResponseBody
    public int badworld_number(){
        return badworldService.badworld_number();
    }

    @RequestMapping("/bin/GetBadworld")
    @ResponseBody
    public Badworld GetBadworld(String id){
        return badworldService.GetBadworld(id);
    }

    @RequestMapping("/bin/badworld_delete")
    @ResponseBody
    public void badworld_delete(String id){
        badworldService.badworld_delete(id);
    }

    @RequestMapping("/bin/badworld_insert")
    @ResponseBody
    public void badworld_insert(Badworld badworld){
        badworldService.badworld_insert(badworld);
    }

    @RequestMapping("/bin/badworld_exam")
    @ResponseBody
    public Set<String> badworld_exam(String data){
        return badworldService.badworld_exam(data);
    }

    @RequestMapping("/bin/badworld_filter")
    @ResponseBody
    public String badworld_filter(String data){
        return badworldService.badworld_filter(data);
    }

    @RequestMapping("/bin/img_exam")
    @ResponseBody
    public String Img_Exam(@RequestParam("file")MultipartFile file){
        List<String> strs = FileUtil.fileupload(file);
        String filePath = strs.get(0).substring(1)+strs.get(1);
        //识别图片
        String str = ImgCheckUtil.checkPornograp(filePath);
        JSONObject jsonObject = JSONObject.parseObject(str);
        String result = jsonObject.getString("conclusion");
        File f = new File(filePath);
        f.delete();
        return result;
    }
}