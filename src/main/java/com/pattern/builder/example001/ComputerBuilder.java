package com.pattern.builder.example001;

/**
 * @package : com.pattern.builder.example001
 * @class : ComputerBuilder
 * @description : 建造各个部件的抽象接口
 * @author : lyf
 * @date : 2017-10-10 星期二 14:42:58
 * @version : V1.0.0
 * @copyright : 2017 lyf Inc. All rights reserved.
 */
public interface ComputerBuilder {
    void buildCpu();
    void buildMemory();
    void buildDisk();
    void buildScreen();
    void buildPower();
    void buildKeyboard();
    void buildMouse();

    Computer buildComputer();
}
