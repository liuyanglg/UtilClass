package com.excel;

import com.excel.model.ExcelRecord;
import com.excel.utils.ExcelUtil2;

import java.util.HashSet;
import java.util.Set;

public class TestExcelUtil {
    public static void main(String[] args) {
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
