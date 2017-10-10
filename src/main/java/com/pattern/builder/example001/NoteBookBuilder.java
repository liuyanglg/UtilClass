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
public class NoteBookBuilder implements ComputerBuilder{
   private Computer computer = null;

    public NoteBookBuilder() {
        computer = new Computer();
    }

    public void buildCpu() {
        computer.setCpu("Intel core i7 6500U Cpu");
    }

    public void buildMemory() {
        computer.setMemory("Samsung 8G DDR3L Memory");
    }

    public void buildDisk() {
        computer.setDisk("Samsung 256GB 850 PRO SSD");
    }

    public void buildScreen() {
        computer.setScreen("LG 1920*1080 14.0 inches Screen");
    }

    public void buildPower() {
        computer.setPower("LG 8000mAh Battery");
    }

    public void buildKeyboard() {
        computer.setKeyboard("SteelSeries RGB Keyboard");
    }

    public void buildMouse() {
        computer.setMouse("Logitech M700 Mouse");
    }

    public Computer buildComputer() {
        return computer;
    }
}
