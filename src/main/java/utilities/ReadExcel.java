package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ReadExcel(String excelpath) throws IOException {
		//Reading excel file for on click events
		try {
				FileInputStream file = new FileInputStream(excelpath);
				wb = new XSSFWorkbook(file);
				sheet = wb.getSheetAt(0);
				System.out.println("file present");
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
		public int RowCount() {
				int rows = sheet.getLastRowNum();
				rows = rows + 1;
				System.out.println("total rows in excel sheet are --> " +rows);
				return rows;
		}
		
		public int ColumnCount() {
				Row r = sheet.getRow(2);
				int colm = r.getLastCellNum();
				System.out.println("total column ->" + colm);
				return colm;
		}
		
		public String getdata(int sheetindex, int row, int colmn) {
			System.out.println("--reading data from excel sheet--");
			String data = sheet.getRow(row).getCell(colmn).getStringCellValue();
			System.out.println("passing data to another class");
			return data;
		}
	
}
