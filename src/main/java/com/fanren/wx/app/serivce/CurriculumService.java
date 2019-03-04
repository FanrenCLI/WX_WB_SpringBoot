package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.CurriculumMapper;
import com.fanren.wx.app.pojo.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/4 17:25
 * @Description: Class
 * @version:
 */
@Service
public class CurriculumService {
    @Autowired
    private CurriculumMapper curriculumMapper;
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
