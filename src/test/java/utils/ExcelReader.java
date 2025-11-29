package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {

    public static Object[][] getExcelData(String filePath, String sheetName) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet("Sheet1");

            int rowCount = sh.getPhysicalNumberOfRows();
            int colCount = sh.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                Row row = sh.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell != null ? cell.toString() : "";
                }
            }

            wb.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
