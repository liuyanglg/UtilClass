package com.pattern.builder.example002;

/**
 * @package : com.pattern.builder.example002
 * @class : StudentBuilder
 * @description : 另类的生产者模式
 * @author : lyf
 * @date : 2017-10-10 星期二 16:06:50
 * @version : V1.0.0
 * @copyright : 2017 lyf Inc. All rights reserved.
 */
public class StudentBuilder {
    private Student student = null;
    public StudentBuilder(String id,String name){
        student = new Student();
        student.setId(id);
        student.setName(name);
    }
    public StudentBuilder age(int age){
        student.setAge(age);
        return this;
    }

    public StudentBuilder sex(String sex){
        student.setSex(sex);
        return this;
    }

    public StudentBuilder phone(String phone){
        student.setPhone(phone);
        return this;
    }

    public StudentBuilder collage(String collage){
        student.setCollage(collage);
        return this;
    }

    public Student build(){
        return this.student;
    }
}
