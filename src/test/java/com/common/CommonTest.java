package com.common;

import org.junit.Test;

/**
 *Created by  liuya
 *2017/12/14
 */
public class CommonTest {
    @Test
    public void testMethod() throws  Exception{
        String s = "\t  a  \n b \tsss\tc";
        System.out.println(removeBlank(s));
    }
    public String removeBlank(String str){
        return str.replaceAll("\\s", "");
    }
}
