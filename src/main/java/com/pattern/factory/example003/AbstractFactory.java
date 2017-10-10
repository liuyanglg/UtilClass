package com.pattern.factory.example003;

/**
 * @package : com.pattern.factory.example003
 * @class : AbstractFactory
 * @description : 抽象工厂模式
 * @author : lyf
 * @date : 2017-10-10 星期二 11:19:11
 * @version : V1.0.0
 * @copyright : 2017 lyf Inc. All rights reserved.
 */
public interface AbstractFactory {
    Car createCar();

    Bus createBus();
}
