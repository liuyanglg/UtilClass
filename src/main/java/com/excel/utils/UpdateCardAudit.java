package com.excel.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class UpdateCardAudit {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://192.168.210.33:3306/platformkf?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
    public static final String USER = "dev";
    public static final String PASSWORD = "dev123456";
    String path = "D:\\Download\\corret_data.xlsx";


    public static void updateTable(String excelPath) {
        String sql = "UPDATE tb_cmp_card_audit SET taxid=?,name=?,address=?,telephone=?,bank=? WHERE id=?;";
        String[] paramsArray = {"taxid", "name", "address", "telephone", "bank", "id"};
        InputStream is=null;
        Connection conn=null;
        try {
            is = ExcelUtil.readFile(excelPath);
            Workbook wb = new XSSFWorkbook(is);
            List<Map<String, Object>> list = ExcelUtil.importSimpleExcel(wb, "已订正数据", 1, 0);
            conn = JdbcUtil.getConnection(DRIVER, URL, USER, PASSWORD);
            JdbcUtil.executeBatchUpdate(conn,sql,list,paramsArray);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(is);
            close(conn);
        }

    }

    public static void close(InputStream x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
