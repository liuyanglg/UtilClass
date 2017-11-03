package com.pattern.template;

public abstract class AbstractTemplate {
    public long getTime() {
        long start = System.currentTimeMillis();
        //这里面可以放入你想测试的运行程序的时间
        code();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public abstract void code();

}
