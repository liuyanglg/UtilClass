package com.pattern.builder.example002;

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
