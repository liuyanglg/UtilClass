package com.pattern.template;

public class SubDemo extends AbstractTemplate {
    @Override
    public void code() {
        int sum=10000;
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(51);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum -= i;
        }
        System.out.println(sum);
    }
}
