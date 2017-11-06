package com.excel.utils;

import com.excel.model.CardAuditCorrect;
import com.excel.model.ExcelRecord;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by liuyang on 2017/6/27.
 */
public class ExcelUtil2 {

    public static void exportExcel(Set<Object> objectSet, String filename) {
        String companyName = "销方企业名称";
        String identifyNumber = "销方纳税人识别号";
        String exceptionNumber = "异常商品数量";
        String excelTitle[] = new String[]{companyName, identifyNumber, exceptionNumber};
        //建立工作簿
        XSSFWorkbook wb = new XSSFWorkbook();
        FileOutputStream out = null;

        try {
            //创建工作表
            XSSFSheet sheet = wb.createSheet("Sheet0");
            int rowIndex = 0;
            XSSFRow row = sheet.createRow(rowIndex++);
            for (int i = 0; i < excelTitle.length; i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(excelTitle[i]);
                sheet.setColumnWidth(i, excelTitle[i].getBytes().length * 256);
            }

            Iterator<Object> iterator = objectSet.iterator();
            while (iterator.hasNext()) {
                ExcelRecord record = (ExcelRecord) iterator.next();
                XSSFRow xssfRow = sheet.createRow(rowIndex++);
                XSSFCell xssfCell = xssfRow.createCell(0);
                xssfCell.setCellValue(record.getCompanyName());
                xssfCell = xssfRow.createCell(1);
                xssfCell.setCellValue(record.getIdentifyNumber());
                xssfCell = xssfRow.createCell(2);
                xssfCell.setCellValue(record.getGoodsNumber().size());
            }
            //解析文件路径，并创建文件夹
            String filePath = filename.substring(0, filename.lastIndexOf("\\") + 1);
            File fp = new File(filePath);
            if (!fp.exists()) {
                fp.mkdirs();
            }
            if (!filename.endsWith(".xls") && !filename.endsWith(".xlsx")) {
                filename += ".xlsx";
            }
            out = new FileOutputStream(filename);
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static List<CardAuditCorrect> importSimpleExcel(InputStream inputStream) {
        Workbook wb;
        Sheet sheet;
        Row row;
        int rowNum = 0;
        int colNum = 0;
        List<CardAuditCorrect> auditCorrectList = new ArrayList<CardAuditCorrect>();
        try {
            wb = new XSSFWorkbook(inputStream);
            sheet = wb.getSheet("已订正数据");
            rowNum = sheet.getLastRowNum();
            colNum = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int i = 1; i < rowNum; i++) {
                row = sheet.getRow(i);
                if(row==null){
                    continue;
                }
                CardAuditCorrect auditCorrect = new CardAuditCorrect();
                for (int j = 0; j < colNum; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        Object cellValue = getCellValue(row.getCell(j));
                        if (cellValue instanceof String) {
                            cellValue = removeSpecSymbol((String) cellValue);
                        }
                        auditCorrect = convertToObject(auditCorrect, j, cellValue);
                    }
                }
                if (auditCorrect.getId() != null) {
                    auditCorrectList.add(auditCorrect);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auditCorrectList;
    }

    private static Object getCellValue(Cell cell) {
        Object cellValue = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                String str = (String) cellValue;
                if(str!=null&&str.trim().length()==0){
                    cellValue = null;
                }
                break;
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = (Double) cell.getNumericCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                cellValue = null;
                break;
            default:
                cellValue = null;
                break;
        }
        return cellValue;
    }

    public static String removeSpecSymbol(String string) {
        String str = string.replaceAll("@", "");
        return str;
    }

    public static CardAuditCorrect convertToObject(CardAuditCorrect cardAuditCorrect, int index, Object content) throws Exception {
        switch (index) {
            case 0:
                cardAuditCorrect.setId(Integer.parseInt((String) content));
                break;
            case 2:
                cardAuditCorrect.setTaxid((String) content);
                break;
            case 3:
                cardAuditCorrect.setName((String) content);
                break;
            case 4:
                cardAuditCorrect.setAddress((String) content);
                break;
            case 5:
                cardAuditCorrect.setTelephone((String) content);
                break;
            case 6:
                cardAuditCorrect.setBank((String) content);
                break;
            case 7:
                cardAuditCorrect.setAccount((String) content);
                break;
            default:
                break;
        }
        return cardAuditCorrect;
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
}
