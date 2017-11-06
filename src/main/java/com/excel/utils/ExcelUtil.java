package com.excel.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class ExcelUtil {
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
        Map tableConfigMap = initTableConfig();

        Sheet sheet;
        Row row;
        int rowNum = 0;
        int colNum = 0;
        try {
            sheet = wb.getSheet(sheetName);
            rowNum = sheet.getLastRowNum();
            colNum = sheet.getRow(0).getPhysicalNumberOfCells();
            if (endIndex > rowNum || endIndex == 0) {
                endIndex = rowNum;
            }

            for (int i = 1; i < endIndex; i++) {
                row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
                for (int j = 0; j < colNum; j++) {
                    Cell cell = row.getCell(j);
                    Map<String, Object> colConfigMap = (Map<String, Object>) tableConfigMap.get("" + j);
                    if (cell != null && colConfigMap != null) {
                        Object cellValue = getCellValue(cell, tableConfigMap, j);
                        String columnLabel = (String) colConfigMap.get("name");
                        rowMap.put(columnLabel, cellValue);
                    }
                }
                if (!rowMap.isEmpty()) {
                    list.add(rowMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static Map initTableConfig() {
        Map<String, Object> configMap = new HashMap<String, Object>();
        Map<String, Object> columnMap = new HashMap<String, Object>();
        configMap.put("0", setColumnMap(0, "id", Type.String));
        configMap.put("2", setColumnMap(2, "taxid", Type.String));
        configMap.put("3", setColumnMap(3, "name", Type.String));
        configMap.put("4", setColumnMap(4, "address", Type.String));
        configMap.put("5", setColumnMap(5, "telephone", Type.String));
        configMap.put("6", setColumnMap(6, "bank", Type.String));
        configMap.put("7", setColumnMap(7, "account", Type.String));
        return configMap;
    }

    public static Map<String, Object> setColumnMap(Integer index, String name, Type type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("index", index);
        map.put("name", name);
        map.put("type", type);
        return map;
    }

    private static Object getCellValue(Cell cell, Map tableConfigMap, int column) {
        Object cellValue = null;
        Map<String, Object> map = (Map<String, Object>) tableConfigMap.get("" + column);
        if (map != null) {
            Type type = (Type) map.get("type");
            cellValue = switchCellValue(cell, type);
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

    private static Object switchCellValue(Cell cell, Type type) {
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

    private static Boolean getBooleanCellValue(Cell cell) {
        Boolean cellValue = null;
        cellValue = cell.getBooleanCellValue();
        return cellValue;
    }
}
