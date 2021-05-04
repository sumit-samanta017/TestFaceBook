package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fileInput;
	public static XSSFWorkbook wBook;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	// Get total no of rows in excel
	public static int getRowCount(String xFilePath, String xSheetName) throws IOException {

		fileInput = new FileInputStream(xFilePath);
		wBook = new XSSFWorkbook(fileInput);
		wSheet = wBook.getSheet(xSheetName);

		int rowCount = wSheet.getLastRowNum();
		
		//System.out.println(rowCount);

		return rowCount;
	}

	//	Get cell count in each row
	public static int getCellCount(String xFilePath, String xSheetName, int rowCount) throws IOException {

		fileInput = new FileInputStream(xFilePath);
		wBook = new XSSFWorkbook(fileInput);
		wSheet = wBook.getSheet(xSheetName);

		row = wSheet.getRow(rowCount);

		int cellCount = row.getLastCellNum();
		
		//System.out.println(cellCount);

		return cellCount;
	}

	//	Get the values in each cell
	public static String getCellValue(String xFilePath, String xSheetName, int rowCount, int cellCount) throws IOException {

		fileInput = new FileInputStream(xFilePath);
		wBook = new XSSFWorkbook(fileInput);
		wSheet = wBook.getSheet(xSheetName);
		
		row = wSheet.getRow(rowCount);
		cell = row.getCell(cellCount);
		
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		
		//System.out.println(data);
		
		return data;
		
		
		
	}


}
