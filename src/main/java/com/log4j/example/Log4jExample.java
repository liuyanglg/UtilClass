package com.log4j.example;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class Log4jExample {
    public static final String PROPERTY_FILE = "/properties/log4j3.properties";
    public static Logger log = Logger.getLogger(Log4jExample.class.getName());

    public static void initLog4j() {
        String path = getProjectRootPath() + PROPERTY_FILE;
        InputStream is = null;
        Properties pro = new Properties();
        try {
            is = new FileInputStream(path);
//            is = this.getClass().getResourceAsStream(getProjectRootPath()+PROPERTY_FILE);
            pro.load(is);
            Enumeration keys = pro.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
//                System.out.println(key + "：" + pro.getProperty(key));
            }
            PropertyConfigurator.configure(pro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Log4jExample log4jExample = new Log4jExample();
//        log4jExample.initLog4j();
        initLog4j();

        log.debug("debug message");
        log.info("info message");
        log.error("error message");
        log.error("error message");
        log.error("chen llll");
    }

    public static String getProjectRootPath() {
        File file = new File("");
        String projectPath = "";
        try {
            projectPath=file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectPath;
    }
}
