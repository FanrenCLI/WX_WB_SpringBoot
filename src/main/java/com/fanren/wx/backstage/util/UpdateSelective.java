package com.fanren.wx.backstage.util;

import com.fanren.wx.app.pojo.Student;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/4 13:06
 * @Description: Class
 * @version:
 */
public class UpdateSelective {
    public static Map<String,String> selectiveFun(Object object) throws Exception{
        Class c1=object.getClass();
        Map<String,String> map=new HashMap<>();
        Field[] fields=c1.getDeclaredFields();
        for(Field field:fields) {
            map.put(field.getName(), (String) getFieldValue(object, field.getName()));
        }
          return map;
    }
    public static Field getDeclaredField1(Object obj,String fieldName) {
        Field field = null;
        Class c = obj.getClass();
        for(; c != Object.class ; c = c.getSuperclass()){
            try {
                field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            }catch (Exception e){
            }
        }
        return null;
    }
    public static Object getFieldValue(Object object,String fieldName) throws Exception{
        Field field = getDeclaredField1(object,fieldName);
        return field.get(object);
    }

//测试方法
    public static void main(String args[]) throws Exception{
        Student student=new Student();
        student.setClasses("aaa");
        student.setDepartment("sss");
        student.setIdCard("ssaaa");
        student.setStudentId("");
        Map<String,String> map=selectiveFun(student);
        for(String key : map.keySet()){
            String v1 = map.get(key);
            System.out.println(key+": "+v1+";");
        }

    }
}
