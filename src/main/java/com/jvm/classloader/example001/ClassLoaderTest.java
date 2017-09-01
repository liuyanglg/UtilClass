package com.jvm.classloader.example001;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();  //获得ClassLoaderTest这个类的类加载器
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();    //获得父加载器的引用
        }
        System.out.println(loader);

        System.out.println("-------------------------------------------------");
//        String classesPath = ClassLoaderTest.class.getResource("/").getPath();
        String classesPath = "D:/Download/";
        String className = "com.jvm.classloader.example001.ClassSimple";
        MyClassLoader myClassLoader = new MyClassLoader(classesPath);
        try {
            Class clazz = myClassLoader.loadClass(className);
            System.out.println(clazz.getClassLoader());
            System.out.println("-------------------------------------------------");

            Object object = clazz.newInstance();
            Method setName = clazz.getMethod("setName", String.class);
            Object oSetName = setName.invoke(object, "liuyang");
            System.out.println("setName: " + setName);
            System.out.println("object.setName: " + oSetName);
            System.out.println("-------------------------------------------------");

            Method getName = clazz.getMethod("getName", null);
            Object oGetName = getName.invoke(object, null);
            System.out.println("getName: " + getName);
            System.out.println("object.getName: " + oGetName);
            System.out.println("-------------------------------------------------");

            Method setAge = clazz.getMethod("setAge", int.class);
            Object oSetAge = setAge.invoke(object, 22);
            System.out.println("setAge: " + setAge);
            System.out.println("object.setAge: " + oSetAge);
            System.out.println("-------------------------------------------------");

            Method getAge = clazz.getMethod("getAge", null);
            Object oGetAge = getAge.invoke(object, null);
            System.out.println("getAge: " + getAge);
            System.out.println("object.getAge: " + oGetAge);
            System.out.println("-------------------------------------------------");

            Method toString = clazz.getMethod("toString", null);
            Object oToString = toString.invoke(object, null);
            System.out.println("toString: " + toString);
            System.out.println("object.toString: " + oToString);
            System.out.println(object.toString());

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
