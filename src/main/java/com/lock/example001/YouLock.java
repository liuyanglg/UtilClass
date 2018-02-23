package com.lock.example001;

import com.lock.model.People;

import java.util.Random;

/**
 *Created by  liuya
 *2017/12/25
 */
public class YouLock {
    private People people=new People();

    public static void main(String[] args) {
        YouLock youLock = new YouLock();
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    youLock.setAge(new Random().nextInt(10));
                }
            }).start();
        }

        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    youLock.getAge();
                }
            }).start();
        }
    }

    public void setAge(int age) {
        people.setAge(age);
    }

    public int getAge() {
        return people.getAge();
    }
}
