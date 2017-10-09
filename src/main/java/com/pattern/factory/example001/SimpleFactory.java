package com.pattern.factory.example001;

/**
 * @package : com.pattern.factory.example001
 * @class : SimpleFactoryTest
 * @description : 简单工厂模式
 * @author : lyf
 * @date : 2017-10-09 星期一 18:16:12
 * @version : V1.0.0
 * @copyright : 2017 lyf Inc. All rights reserved.
 */
public class SimpleFactory {
    private static Phone phone = null;

    public static Phone getPhone(Class<?> clazz) {
        if(clazz.getName().equals(MiPhone.class.getName())){
            phone=createMiPhone();
        }
        if(clazz.getName().equals(IPhone.class.getName())){
            phone=createIPhone();
        }
        if(clazz.getName().equals(MeizuPhone.class.getName())){
            phone=createMeizuPhone();
        }
        return phone;
    }

    private static MiPhone createMiPhone(){
        return new MiPhone();
    }

    private static IPhone createIPhone(){
        return new IPhone();
    }

    private static MeizuPhone createMeizuPhone(){
        return new MeizuPhone();
    }
}
