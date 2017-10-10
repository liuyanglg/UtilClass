package com.pattern.factory.example003;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractFactoryTest {
    @Test
    public void testAbstractFactory() throws Exception {
        AbstractFactory factory = null;
        factory = new FactoryBenz();
        Car car = factory.createCar();
        Bus bus = factory.createBus();
        car.run();
        bus.carryPassenger();
        factory = new FactoryBMW();
        car = factory.createCar();
        bus = factory.createBus();
        car.run();
        bus.carryPassenger();
    }
}