package com.pattern.prototype.example001;


import java.util.ArrayList;
import java.util.List;

public class HomeWork implements Cloneable{
    private String sid;
    private String name;
    private String major;
    private String subject;
    private List<String> questions;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public HomeWork clone() throws CloneNotSupportedException {
        return (HomeWork) super.clone();
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public void showHomeWork(){
        for(String str: questions){
            System.out.println(str);
        }
    }
}