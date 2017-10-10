package com.pattern.factory.example003;

public class FactoryBenz implements AbstractFactory {
    public Car createCar() {
        return new BenzCar();
    }

    public Bus createBus() {
        return new BenzBus();
    }
}
