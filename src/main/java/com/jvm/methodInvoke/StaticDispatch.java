package com.jvm.methodInvoke;

public class StaticDispatch {
    static abstract class Human {

    }

    static  class Man extends Human {

    }

    static  class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello ,guy!");
    }

    public void sayHello() {
        System.out.println("hello ,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello ,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);

//        //实际类型变化
//        Human man2 = new Man();
//         man2 = new Woman();
//         //静态类型变化
//         sr.sayHello((Man)man2);
//         sr.sayHello((Woman) man2);
    }
}
