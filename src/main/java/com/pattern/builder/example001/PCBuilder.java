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
public class PCBuilder implements ComputerBuilder{
   private Computer computer = null;

    public PCBuilder() {
        computer = new Computer();
    }

    public void buildCpu() {
        computer.setCpu("Intel core i7 8700K Cpu");
    }

    public void buildMemory() {
        computer.setMemory("Kingston 16G DDR4 Memory");
    }

    public void buildDisk() {
        computer.setDisk("Samsung 512GB 850 PRO SSD");
    }

    public void buildScreen() {
        computer.setScreen("Acer 4K 120Hz 23.0 inches Screen");
    }

    public void buildPower() {
        computer.setPower("800w Power");
    }

    public void buildKeyboard() {
        computer.setKeyboard("Cherry MX13 Mechanical Keyboard");
    }

    public void buildMouse() {
        computer.setMouse("Logitech Game Mouse");
    }

    public Computer buildComputer() {
        return computer;
    }
}
