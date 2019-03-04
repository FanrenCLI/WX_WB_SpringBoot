package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.app.pojo.CurriculumExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumMapper {
    //查询所有课程
    List<Curriculum> curriculum_list();
    //查询课程数量
    int curriculum_number();
    //根据课程名称更新课程信息
    void curriculum_update(Curriculum curriculum);
    //模糊查询班级课表
    List<Curriculum> selectCurriculumByClasses(String classes);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    long countByExample(CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int deleteByExample(CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int deleteByPrimaryKey(String kcmc);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int insert(Curriculum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int insertSelective(Curriculum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    List<Curriculum> selectByExample(CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    Curriculum selectByPrimaryKey(String kcmc);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int updateByExampleSelective(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int updateByExample(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int updateByPrimaryKeySelective(Curriculum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Wed Feb 27 15:15:30 CST 2019
     */
    int updateByPrimaryKey(Curriculum record);
}