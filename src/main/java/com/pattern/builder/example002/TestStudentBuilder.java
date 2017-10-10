package com.pattern.builder.example002;

public class TestStudentBuilder {
    public static void main(String[] args) {
        Student student=new StudentBuilder("13011315","mistake")
                .age(22).sex("男").collage("机械学院").phone("15988134908").build();
        System.out.println(student);
    }
}
