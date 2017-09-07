package com.jvm.localVariableTable.example001;

public class SlotTest2 {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a=0;//slot被重复利用
        System.gc();
    }
}
