package com.pattern.template;

public class TestTemplate {
    public static void main(String[] args) {
        // GetTime gt = new GetTime();
        // System.out.println(gt.getTime() + "毫秒");
        AbstractTemplate template = new SubDemo();
        System.out.println(template.getTime() + "毫秒");

        template = new SumDemo();
        System.out.println(template.getTime() + "毫秒");
    }
}
