package com.excel;


import com.excel.model.CardAuditCorrect;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Util {
    public enum Type {
        Integer, Double, String, Date, Boolean
    }

    public static InputStream readFile(String path) throws Exception {
        InputStream is = null;
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        is = new FileInputStream(file);
        return is;
    }

    public static List<Map<String, Object>> importSimpleExcel(Workbook wb, String sheetName, int startIndex, int endIndex) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> columnConfig = initColumnConfig();

        Sheet sheet;
        Row row;
        int rowNum = 0;
        int colNum = 0;
        try {
            sheet = wb.getSheet(sheetName);
            rowNum = sheet.getLastRowNum();
            colNum = sheet.getRow(0).getPhysicalNumberOfCells();
            if (endIndex > colNum) {
                endIndex = colNum;
            }

            for (int i = 1; i < endIndex; i++) {
                row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Map<String, Object> columnMap = new HashMap<String, Object>();
                for (int j = 0; j < colNum; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        Object cellValue = getCellValue(cell,columnConfig,j);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auditCorrectList;
    }


    public static List<Map<String, Object>> initColumnConfig() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> columnMap = new HashMap<String, Object>();
        list.add(setColumnMap(0, "id", Type.String));
        list.add(setColumnMap(2, "taxid", Type.String));
        list.add(setColumnMap(3, "name", Type.String));
        list.add(setColumnMap(4, "address", Type.String));
        list.add(setColumnMap(5, "telephone", Type.String));
        list.add(setColumnMap(6, "bank", Type.String));
        list.add(setColumnMap(7, "account", Type.String));
        return list;
    }

    public static Map<String, Object> setColumnMap(Integer index, String name, Type type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("index", index);
        map.put("name", name);
        map.put("type", type);
        return map;
    }

    private static Object getCellValue(Cell cell,List<Map<String, Object>> columnConfig, int column) {
        Object cellValue = null;
        for (Map<String, Object> map : columnConfig) {
            Integer index = (Integer) map.get("index");
            if (index == column) {
                Type type = (Type) map.get("type");
                cellValue = switchCellValue(cell,type);
            }
        }
        return cellValue;
    }

    private static String getStringCellValue(Cell cell) {
        String cellValue = "";
        cellValue = cell.getStringCellValue();
        if (cellValue != null && cellValue.trim().length() == 0) {
            cellValue = null;
        }
        return cellValue;
    }

    private static Object switchCellValue(Cell cell,Type type) {
        Object cellValue = null;
        switch (type) {
            case Integer:
                cellValue = getIntegerCellValue(cell);
                break;
            case Double:
                cellValue = getDoubleCellValue(cell);
                break;
            case String:
                cellValue = getStringCellValue(cell);
                break;
            case Date:
                cellValue = getDateCellValue(cell);
                break;
            default:
                break;
        }
        return cellValue;
    }

    private static Integer getIntegerCellValue(Cell cell) {
        Integer cellValue = null;
        Double d = cell.getNumericCellValue();
        int i = d.intValue();
        cellValue = i;
        return cellValue;
    }

    private static Double getDoubleCellValue(Cell cell) {
        Double cellValue = null;
        cellValue = cell.getNumericCellValue();
        return cellValue;
    }

    private static Date getDateCellValue(Cell cell) {
        Date cellValue = null;
        cellValue = cell.getDateCellValue();
        return cellValue;
    }
}
