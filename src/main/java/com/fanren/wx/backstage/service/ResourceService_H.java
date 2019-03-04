package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.ResourceMapper;
import com.fanren.wx.app.pojo.Resource;
import com.fanren.wx.app.pojo.ResourceExample;
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
public class ResourceService_H {
    @Autowired
    ResourceMapper resourceMapper;

    public List<Resource> resource_list() {
        return resourceMapper.resource_list();
    }

    public void resource_upload(MultipartFile file, Resource resource) {
        List<String> liststr = FileUtil.fileupload(file);
        String strs[] = file.getOriginalFilename().split("\\.");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        resource.setResourceDir(liststr.get(0).substring(1) + liststr.get(1));
        resource.setResourceName(strs[0]);
        resource.setUploadTime(dateFormat.format(date));
        resource.setDownloadNumber("0");
        resourceMapper.insertSelective(resource);
    }

    public int resource_number() {
        return resourceMapper.resource_number();
    }

    public Resource GetResource(String name) {
        return resourceMapper.GetResource(name);
    }

    public void resource_delete(String name) {
        Resource resource = GetResource(name);
        File file = new File(resource.getResourceDir());
        file.delete();
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceNameEqualTo(name);
        resourceMapper.deleteByExample(resourceExample);
    }

    public void resource_download(String name, HttpServletResponse response) throws UnsupportedEncodingException {
        Resource resource = GetResource(name);
        String filePath = resource.getResourceDir();
        String fileName =filePath.substring(filePath.lastIndexOf("/")+1) ;
        String s[] = fileName.split("\\.");
        //文件原始完整名称
        String realName = resource.getResourceName()+"."+s[1];
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
                    //增加下载量
                    int download_number = Integer.parseInt(resource.getDownloadNumber());
                    download_number++;
                    resource.setDownloadNumber(String.valueOf(download_number));
                    resourceMapper.resource_update_number(resource);
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
}
