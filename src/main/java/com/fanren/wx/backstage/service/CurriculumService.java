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
}
