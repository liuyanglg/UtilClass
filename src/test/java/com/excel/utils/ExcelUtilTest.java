package com.excel.utils;

import com.excel.model.ExcelRecord;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ExcelUtilTest {
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

        ExcelUtil.exportExcel(records,"D:\\logs\\record.xml");
    }

}