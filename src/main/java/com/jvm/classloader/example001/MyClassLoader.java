package com.jvm.classloader.example001;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        byte[] classData = getClassData(name);
        if(classData==null){
            throw new ClassNotFoundException();
        }
        return defineClass(name,classData, 0, classData.length);
    }

    private byte[] getClassData(String name){
        InputStream is = null;
        ByteArrayOutputStream bout = null;
        byte[] bytes = new byte[1024 * 4];
        int len = -1;
        try {
            is = new FileInputStream(classPath);
            bout = new ByteArrayOutputStream();
            while ((len=is.read(bytes) )!= -1) {
                bout.write(bytes,0,len);
            }
            return bout.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
