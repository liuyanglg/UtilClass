package com.pattern.decorator;

public class TomatoCake implements Cake{
    public String getDescription() {
        return "tomato cake";
    }

    public Double cost() {
        return 2.5;
    }
}
