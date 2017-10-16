package com.pattern.prototype.example001;

import java.util.ArrayList;
import java.util.List;

public class TestPrototype {
    public static void main(String[] args)  {
        HomeWork lisiWork = new HomeWork();

        List<String> questions = new ArrayList<String>();
        questions.add("1+1=2");
        questions.add("1+3=4");
        questions.add("5+1=6");
        lisiWork.setName("lisi");
        lisiWork.setMajor("computer science");
        lisiWork.setSid("13055201");
        lisiWork.setSubject("math");
        lisiWork.setQuestions(questions);
        System.out.println(lisiWork);
        HomeWork zhangsanWork = null;
        try {
            zhangsanWork = lisiWork.clone();
            zhangsanWork.setName("zhangsan");
            zhangsanWork.setSid("13011315");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(zhangsanWork);
    }
}
