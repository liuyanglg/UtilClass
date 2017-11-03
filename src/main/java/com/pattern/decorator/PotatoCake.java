package com.pattern.decorator;

public class PotatoCake implements Cake{
    public String getDescription() {
        return "potato cake";
    }

    public Double cost() {
        return 2.0;
    }
}
