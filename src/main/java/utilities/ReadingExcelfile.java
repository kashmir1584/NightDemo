package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadingExcelfile  {

	public XSSFWorkbook wb = null;
	public XSSFSheet sheet = null;
	public FileInputStream fis = null;
	public File file = null;
	public String path;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	
	public ReadingExcelfile(String excelpath) throws IOException  {
			this.path = excelpath;
		try {
			fis = new FileInputStream(excelpath);
			wb = new XSSFWorkbook(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//counting number of rows
	public int RowCount(String sheetname) {
		System.out.println("reading row count for sheet --  " +sheetname);
		int sheetindex = wb.getSheetIndex(sheetname);
		System.out.println("index for sheet " +sheetname + " is " + sheetindex );
		if(sheetindex == -1)
		{
			return 0;
		}else
		{
		sheet = wb.getSheetAt(sheetindex);
		int totalrows = sheet.getLastRowNum();
		totalrows = totalrows + 1;
		System.out.println("Total rows in " +sheetname + " sheet are :: " + totalrows);
		return totalrows;
		}
	}
	
	
	public int RowCount(int sheetindex) {
		System.out.println("entered rowcount method");
		sheet = wb.getSheetAt(sheetindex);
		int totalrows = sheet.getLastRowNum();
		totalrows = totalrows + 1;
		System.out.println("Total rows in test case excel sheet are :: " + totalrows);
		return totalrows;
	}
	
	
	//counting number of columns
	public int TotalColm(String sheetname, int rowindex) {
		sheet = wb.getSheet(sheetname);
		Row r = sheet.getRow(rowindex);
		int totalcolmn = r.getLastCellNum();
		System.out.println("total usable columns in this excel are :: " + totalcolmn);
		return totalcolmn;
	}
	
	
	//counting number of columns
		public int TotalColm(int sheetindex, int rowindex) {
			sheet = wb.getSheetAt(sheetindex);
			Row r = sheet.getRow(rowindex);
			int totalcolmn = r.getLastCellNum();
			System.out.println("total usable columns in this excel are :: " + totalcolmn);
			return totalcolmn;
		}
	
	//fetching the data from excel sheet
	public String getdata(String sheetname, int row, int col) {
		String data = null;
		sheet = wb.getSheet(sheetname);
		data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	
	//fetching the data from excel sheet
		public String getdata(int sheetindex, int row, int col) {
			String data = null;
			sheet = wb.getSheetAt(sheetindex);
			data = sheet.getRow(row).getCell(col).getStringCellValue();
			
			return data;
		}
		
		
		//fetching the data from excel sheet
				public String getdata(String sheetname, int rowNum, String colname) 
				{
						System.out.println("---entered getdata method------");
					try {
							if(rowNum <=0){
								return "";
							}
							sheet = wb.getSheet(sheetname);	
							System.out.println("this sheet name is :: "+sheetname + "and colname is ::" +colname);
							int index = wb.getSheetIndex(sheetname);
							System.out.println("sheetindex is :: " + index);
							if(index == -1)
							{
								System.out.println("given sheet is not present:-"+sheetname);
								return "";
							}
							
						int colnum = -1;
														
					//	sheet = wb.getSheetAt(index);	
						row = sheet.getRow(0);
						
						
						for(int i = 0; i <row.getLastCellNum(); i++) 
						{
							if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
							{
								colnum = i;
							}
						}
						
						System.out.println("colm number :: " + colnum);
						
						if(colnum == -1)
						{
							System.out.println("wrong column number found ");
							return "";
						}
						
						sheet = wb.getSheetAt(index);
						
						row = sheet.getRow(rowNum);
						
						if(row==null){
							return "";
						}
						
						
						cell = row.getCell(colnum);
						
					/*	if(cell == null)
							System.out.println("cell not present");
					*/	
						if(cell.getCellTypeEnum() == CellType.STRING)
						{
							return cell.getStringCellValue();
						}else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
						{
							String cellvalue = String.valueOf(cell.getNumericCellValue());
							if(HSSFDateUtil.isCellDateFormatted(cell))
							{
								SimpleDateFormat df = new SimpleDateFormat("dd/mm/yy");
								Date date = cell.getDateCellValue();
								cellvalue = df.format(date);
							}
							return cellvalue;
						}else if(cell.getCellTypeEnum() == CellType.BLANK)
						{
							return "";	
						}else 
							return String.valueOf(cell.getBooleanCellValue());
					} catch (Exception e) {
						return "value not found";
					}
				}
}

