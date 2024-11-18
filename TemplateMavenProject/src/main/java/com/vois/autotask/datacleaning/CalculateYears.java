package com.vois.autotask.datacleaning;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateYears {
    public static void calculateYears(String filePath) {
        try {
            // 1- Read the file
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            final Pattern pattern = Pattern.compile("[0-9]{4}");
            /*
            2- Loop over the rows
            3- calculate the number of years
            4- write to the "How Many years in _VOIS" Column
             */
            sheet.forEach(row -> {
                Cell cell = row.getCell(2);
                if (cell.getCellType() != CellType.STRING) {
                    String cellValue = cell.getLocalDateTimeCellValue().toString();
                    Matcher matcher = pattern.matcher(cellValue);
                    if (matcher.find()) {
                        int year = 2024 - Integer.parseInt(matcher.group(0));
                        row.createCell(3).setCellValue(year);
                    }
                }
            });
            //5- save to the file
            FileOutputStream out = new FileOutputStream("./data/ModifiedData.xlsx");
            workbook.write(out);
            out.close();
            fis.close();
            System.out.println("Done Updating years");
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
