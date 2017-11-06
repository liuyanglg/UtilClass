package com.excel.utils;

import com.excel.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class UtilTest {
    @Test
    public void importSimpleExcel() throws Exception {
        String path = "D:\\Download\\corret_data.xlsx";
        InputStream is = ExcelUtil.readFile(path);
        Workbook  wb = new XSSFWorkbook(is);
        List<Map<String, Object>> list = ExcelUtil.importSimpleExcel(wb, "已订正数据", 1, 20);
        System.out.println(list);
    }

}