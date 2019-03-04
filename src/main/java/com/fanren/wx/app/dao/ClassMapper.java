package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Class;
import com.fanren.wx.app.pojo.ClassExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassMapper {
    //根据班级编号更新班级信息
    void class_update(Class c);
    //获取所有班级数量
    int class_number();
    //获取所有班级信息
    List<Class> class_list();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    long countByExample(ClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int deleteByExample(ClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int deleteByPrimaryKey(String classId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int insert(Class record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int insertSelective(Class record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    List<Class> selectByExample(ClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    Class selectByPrimaryKey(String classId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int updateByPrimaryKeySelective(Class record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_list
     *
     * @mbg.generated Mon Feb 11 10:15:00 CST 2019
     */
    int updateByPrimaryKey(Class record);
}