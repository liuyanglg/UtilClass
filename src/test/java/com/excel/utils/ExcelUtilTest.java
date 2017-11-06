package com.excel.utils;

import com.excel.model.ExcelRecord;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class ExcelUtilTest {
    @Test
    public void importSimpleExcel() throws Exception {
        String path = "D:\\Download\\corret_data.xlsx";
        InputStream is = ExcelUtil2.readFile(path);
        System.out.println(ExcelUtil2.importSimpleExcel(is));
    }

    @Test
    public void removeSpecSymbol() throws Exception {
        System.out.println(ExcelUtil2.removeSpecSymbol("123@"));
    }

    @Test
    public void exportExcel() throws Exception {
        Set<Object> records = new HashSet<Object>();
        for(int i=0;i<65555;i++){
            ExcelRecord record = new ExcelRecord();

            Set<String> goodsNumber = new HashSet<String>();
            goodsNumber.add("goods number" + i);
            record.setCompanyName("company"+i);
            record.setGoodsNumber(goodsNumber);
            record.setIdentifyNumber("identify number"+i);
            records.add(record);
        }

        ExcelUtil2.exportExcel(records,"D:\\logs\\record.xml");
    }

}