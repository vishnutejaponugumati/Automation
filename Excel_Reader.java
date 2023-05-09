package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public static XSSFSheet ExcelWSheet;

	public static XSSFWorkbook ExcelWBook;

	public static XSSFCell Cell;

	public static XSSFRow Row;
	// public static String[][] tabArray = null;
	public static String FilePath ="src/main/java/com/test/automation/uiAutomation/data/TestData.xlsx";
	public static String SheetName = "LoginTestData";
	public static void setExcelData() throws IOException {

		FileInputStream ExcelFile = new FileInputStream(FilePath);

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		/*
		 * int startRow = 1; int startCol = 1; int ci,cj; int totalRows =
		 * ExcelWSheet.getLastRowNum();
		 * 
		 * // you can write a function as well to get Column count int totalCols = 2;
		 * tabArray=new String[totalRows][totalCols]; ci=0; for (int
		 * i=startRow;i<=totalRows;i++, ci++) { cj=0; for (int
		 * j=startCol;j<=totalCols;j++, cj++){ tabArray[ci][cj]=getCellData(i,j);
		 * System.out.println(tabArray[ci][cj]);
		 */
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		String CellData = Cell.getStringCellValue();

		return CellData;

	}

}