package com.fanren.wx.app.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter@Getter
public class User implements Serializable{
    private String picture_dir;
    private String picture;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_list.user_id
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_list.pwd
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    private String pwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_list.open_id
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    private String openId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_list.role
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    private String role;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_list.user_id
     *
     * @return the value of user_list.user_id
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_list.user_id
     *
     * @param userId the value for user_list.user_id
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_list.pwd
     *
     * @return the value of user_list.pwd
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_list.pwd
     *
     * @param pwd the value for user_list.pwd
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_list.open_id
     *
     * @return the value of user_list.open_id
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_list.open_id
     *
     * @param openId the value for user_list.open_id
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_list.role
     *
     * @return the value of user_list.role
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_list.role
     *
     * @param role the value for user_list.role
     *
     * @mbg.generated Sun Jan 27 12:20:19 CST 2019
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}