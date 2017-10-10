package com.pattern.builder.example001;

/**
 * @package : com.pattern.builder.example001
 * @class : NoteBookBuilder
 * @description : 装配产品
 * @author : lyf
 * @date : 2017-10-10 星期二 14:44:21
 * @version : V1.0.0
 * @copyright : 2017 lyf Inc. All rights reserved.
 */
public class MacBuilder implements ComputerBuilder{
   private Computer computer = null;

    public MacBuilder() {
        computer = new Computer();
    }

    public void buildCpu() {
        computer.setCpu("Intel core i5 6500 Cpu");
    }

    public void buildMemory() {
        computer.setMemory("Samsuang 16G DDR4 Memory");
    }

    public void buildDisk() {
        computer.setDisk("Samsung 512GB 950 PRO M.2 PCiEx8 SSD");
    }

    public void buildScreen() {
        computer.setScreen("Apple 5K 120Hz 27.0 inches Screen");
    }

    public void buildPower() {
        computer.setPower("600w Power");
    }

    public void buildKeyboard() {
        computer.setKeyboard("Apple Keyboard");
    }

    public void buildMouse() {
        computer.setMouse("Apple Mouse");
    }

    public Computer buildComputer() {
        return computer;
    }
}
