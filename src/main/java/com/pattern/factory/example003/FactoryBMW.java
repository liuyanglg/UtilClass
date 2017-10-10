package com.pattern.factory.example003;

public class FactoryBMW implements AbstractFactory {
    public Car createCar() {
        return new BMWCar();
    }

    public Bus createBus() {
        return new BMWBus();
    }
}
