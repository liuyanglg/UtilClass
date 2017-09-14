package com.designPattern.proxy.example002;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @package : com.designPattern.proxy.example002
 * @class : DynamicProxyTest
 * @description : 动态代理测试类
 * @author : liuyang
 * @date : 2017-09-12 星期二 10:43:26
 * @version : V1.0.0
 * @copyright : 2017 liuyang Inc. All rights reserved.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, new ProxyHandler(realSubject));
        proxySubject.doSomething();
        createProxyClassFile();
    }

    public static void createProxyClassFile() {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(name + ".class");
            outputStream.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
