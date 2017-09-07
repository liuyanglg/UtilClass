package com.jvm.localVariableTable.example001;

public class SlotTest1 {
    public static void main(String[] args) {
        byte[]placeholder=new byte[64*1024*1024];
        System.gc();
    }
}
