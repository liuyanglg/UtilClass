package com.pattern.callback.example002;

/**
 *Created by  liuya
 *2018/2/23
 */
public class Misty implements Student {
    @Override
    public void resolveQuestion(Teacher teacher) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        teacher.askQuestion("1+1=?");

    }
}
