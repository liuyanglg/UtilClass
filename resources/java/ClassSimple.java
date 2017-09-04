package com.jvm.classloader.example001;

public class ClassSimple {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ClassSimple{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
