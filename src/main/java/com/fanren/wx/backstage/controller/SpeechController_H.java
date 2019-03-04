package com.fanren.wx.backstage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.backstage.util.FileUtil;
import com.fanren.wx.backstage.util.SpeechUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SpeechController_H {

    @RequestMapping("/bin/TextToMp3")
    @ResponseBody
    public String TextToMp3(String data){
        String filepath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
        String filename = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())+".mp3";
        SpeechUtil.SpeechSynthesizer(data,filepath.substring(1)+filename);
        return "http://localhost:8080/"+filename;
    }

    @RequestMapping("/bin/Mp3ToText")
    @ResponseBody
    public String Mp3ToText(@RequestParam("filemp3")MultipartFile file){
        //上传文件
        List<String> strs = FileUtil.fileupload(file);
        //获取文件的完整路径
        String fileFullPath = strs.get(0).substring(1)+strs.get(1);
        //修改文件后缀为.pcm
        String s[] = fileFullPath.split("\\.");
        String pcmfilePath = s[0]+".pcm";
        SpeechUtil.convertMP32Pcm(fileFullPath,pcmfilePath);
        String str = SpeechUtil.SpeechRecognition(pcmfilePath, "pcm");
        JSONObject jsonObject = JSONObject.parseObject(str);
        String result = jsonObject.getString("result");
        return result;
    }
}
