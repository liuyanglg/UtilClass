package com.log4j.example;

import org.apache.log4j.Logger;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.Properties;

public class Log4jExample {
    public static final String PROPERTY_FILE = "properties/log4j.properties";
    public static Logger log = Logger.getLogger(Log4jExample.class.getName());

    public static void initLog4j(){
        InputStream is=null;
        Properties pro = new Properties();
        is = 
    }


    public static void main(String[] args) {
        log.debug("debug message");
        log.info("info message");
    }
}
