package com.jvm;

import java.net.URL;

public class JvmExample {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }
}
