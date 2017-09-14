package com.designPattern.proxy.example001;

/**
 * @package : com.designPattern.proxy.example001
 * @class : DynamicProxyTest
 * @description : 静态代理测试类
 * @author : liuya
 * @date : 2017-09-12 星期二 10:24:55
 * @version : V1.0.0
 * @copyright : 2017 liuya Inc. All rights reserved.
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.doSomething();
    }
}
