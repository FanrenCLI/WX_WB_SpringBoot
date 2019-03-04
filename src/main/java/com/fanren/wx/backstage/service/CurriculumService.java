package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.CurriculumMapper;
import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.app.pojo.CurriculumExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {
    @Autowired
    CurriculumMapper curriculumMapper;

    public List<Curriculum> curriculum_list(){
        return curriculumMapper.curriculum_list();
    }

    public int curriculum_number(){
        return curriculumMapper.curriculum_number();
    }

    public Curriculum GetCurriculum(String name){
        CurriculumExample curriculumExample = new CurriculumExample();
        CurriculumExample.Criteria criteria = curriculumExample.createCriteria();
        criteria.andKcmcEqualTo(name);
        List<Curriculum> curriculas = curriculumMapper.selectByExample(curriculumExample);
        return curriculas.get(0);
    }

    public void curriculum_insert(Curriculum curriculum){
        curriculumMapper.insert(curriculum);
    }

    public void curriculum_update(Curriculum curriculum){
        curriculumMapper.curriculum_update(curriculum);
    }

    public void curriculum_delete(String name){
        CurriculumExample curriculumExample = new CurriculumExample();
        CurriculumExample.Criteria criteria = curriculumExample.createCriteria();
        criteria.andKcmcEqualTo(name);
        curriculumMapper.deleteByExample(curriculumExample);
    }
    /**上面是你的方法 下面的是我的  别乱写
    * @Author: FanrenCLI
    * @Date: 21:49 2019/2/28
    * @param: null
    * @Description: Method
    */
    public List<Curriculum> getCurrInfo(String classes){
        return curriculumMapper.selectCurriculumByClasses(classes);
    }
}
