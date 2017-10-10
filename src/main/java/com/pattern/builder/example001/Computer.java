package com.pattern.builder.example001;

/**
 * @package : com.pattern.builder.example001
 * @class : Computer
 * @description : 产品类
 * @author : lyf
 * @date : 2017-10-10 星期二 14:41:56
 * @version : V1.0.0
 * @copyright : 2017 lyf Inc. All rights reserved.
 */
public class Computer {
    private String cpu;
    private String memory;
    private String disk;
    private String screen;
    private String power;
    private String keyboard;
    private String mouse;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", screen='" + screen + '\'' +
                ", power='" + power + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
