package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.app.pojo.CurriculumExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumMapper {


    List<Curriculum> selectCurriculumByClasses(String classes);
     /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Mon Mar 04 16:48:24 CST 2019
     */
    long countByExample(CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Mon Mar 04 16:48:24 CST 2019
     */
    int deleteByExample(CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Mon Mar 04 16:48:24 CST 2019
     */
    int insert(Curriculum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Mon Mar 04 16:48:24 CST 2019
     */
    int insertSelective(Curriculum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Mon Mar 04 16:48:24 CST 2019
     */
    List<Curriculum> selectByExample(CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Mon Mar 04 16:48:24 CST 2019
     */
    int updateByExampleSelective(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curriculum_list
     *
     * @mbg.generated Mon Mar 04 16:48:24 CST 2019
     */
    int updateByExample(@Param("record") Curriculum record, @Param("example") CurriculumExample example);
}