package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.InformMapper;
import com.fanren.wx.app.pojo.Inform;
import com.fanren.wx.app.pojo.InformExample;
import com.fanren.wx.backstage.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InformService_H {
    @Autowired
    InformMapper informMapper;

    public List<Inform> inform_list(){
        InformExample informExample = new InformExample();
        return informMapper.selectByExample(informExample);
    }

    //通知带附件
    public void inform_insert(MultipartFile file,Inform inform){
        List<String> strs = FileUtil.fileupload(file);
        inform.setAnnexTitle(file.getOriginalFilename());
        inform.setAnnexDir(strs.get(0).substring(1)+strs.get(1));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        inform.setTime(dateFormat.format(date));
        informMapper.insert(inform);
    }

    //通知不带附件
    public void inform_insert(Inform inform){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        inform.setTime(dateFormat.format(date));
        informMapper.insert(inform);
    }

    public Inform GetInform(String title){
        InformExample informExample = new InformExample();
        InformExample.Criteria criteria = informExample.createCriteria();
        criteria.andTitleEqualTo(title);
        Inform inform = informMapper.selectByExample(informExample).get(0);
        return inform;
    }

    public void annex_download(String title, HttpServletResponse response)throws UnsupportedEncodingException {
        Inform inform = GetInform(title);
        String filePath = inform.getAnnexDir();
        String fileName =filePath.substring(filePath.lastIndexOf("/")+1) ;
        //文件原始完整名称
        String realName = inform.getAnnexTitle();
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            File file = new File(filePath);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(realName.getBytes("utf-8"), "ISO8859-1"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("成功!");
                }
                catch (Exception e) {
                    System.out.println("失败!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void inform_delete(String title){
        Inform inform = GetInform(title);
        if(inform.getAnnexTitle()!=null){
            File file = new File(inform.getAnnexDir());
            file.delete();
        }
        InformExample informExample = new InformExample();
        InformExample.Criteria criteria = informExample.createCriteria();
        criteria.andTitleEqualTo(title);
        informMapper.deleteByExample(informExample);
    }

    public void inform_update(MultipartFile file,Inform info){
        //删除源文件
        Inform inform = GetInform(info.getTitle());
        if (inform.getAnnexTitle()!=null){
            File deletefile = new File(inform.getAnnexDir());
            deletefile.delete();
        }
        //上传新文件
        List<String> strs = FileUtil.fileupload(file);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //设置发布时间
        info.setTime(dateFormat.format(date));
        //设置新文件名
        info.setAnnexTitle(file.getOriginalFilename());
        //设置新文件路径
        info.setAnnexDir(strs.get(0).substring(1)+strs.get(1));
        //数据更新
        informMapper.inform_update(info);
    }

    public void inform_update(Inform inform){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        inform.setTime(dateFormat.format(date));
        informMapper.inform_update(inform);
    }

    public long inform_number(){
        InformExample informExample = new InformExample();
        InformExample.Criteria criteria = informExample.createCriteria();
        return informMapper.countByExample(informExample);
    }
}
