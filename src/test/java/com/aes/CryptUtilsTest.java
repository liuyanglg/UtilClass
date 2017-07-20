package com.aes;

import org.junit.Test;

import java.io.File;

/**
 * Created by liuya on 2017/7/13.
 */
public class CryptUtilsTest {
    @Test
    public void encryptFile() throws Exception {
        String fp = "E:\\Config\\work\\jdbc2\\jdbc.properties.txt";
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input file path: ");
//        String inputPath=sc.next();
        File sourceFile = new File(fp);
        if(!sourceFile.exists()){
            System.out.println("file is not exist");
            return;
        }
        String fileType = ".txt";
        String key = "97DC0D40FCFB425EA2A94C3B34ED99F9";
        File file=CryptUtils.encryptFile(sourceFile, fileType, key);

//        file.createNewFile();
    }

    @Test
    public void decryptFile() throws Exception {
        String fp = "D:\\Checkout\\jdbc.properties";
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input file path: ");
//        String inputPath=sc.next();
        File sourceFile = new File(fp);
        if(!sourceFile.exists()){
            System.out.println("file is not exist");
            return;
        }
        String fileType = ".txt";
        String key = "97DC0D40FCFB425EA2A94C3B34ED99F9";
        File file=CryptUtils.decryptFile(sourceFile, fileType, key);
    }

}