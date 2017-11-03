package com.pattern.template;

import java.io.*;

public class SumDemo extends AbstractTemplate {

    @Override
    public void code() {
        int sum=0;
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
        }
        System.out.println(sum);
    }

}