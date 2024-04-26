package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	static String path = "D:\\ExcelData.xlsx";
	
	public static File file;
	
	public static Workbook workbook;

	public static String getemail() throws InvalidFormatException, IOException {
		
		 file = new File(path);
		 workbook = new XSSFWorkbook(file); // workbook interface ,
		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(0);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		return stringCellValue;

	}
	
	public static String getpassword() throws InvalidFormatException, IOException {
		
		 file = new File(path);
		 workbook = new XSSFWorkbook(file); // workbook interface ,
		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(1);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		return stringCellValue;
		
	}
	
	public static String getfirstName() throws InvalidFormatException, IOException {
		
		 file = new File(path);
		 workbook = new XSSFWorkbook(file); // workbook interface ,
		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(2);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		return stringCellValue;
		
	}
	
	public static String getlasttName() throws InvalidFormatException, IOException {
		
		 file = new File(path);
		 workbook = new XSSFWorkbook(file); // workbook interface ,
		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(3);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		return stringCellValue;
		
	}
	
	public static String getdob() throws InvalidFormatException, IOException {
		
		 file = new File(path);
		 workbook = new XSSFWorkbook(file); // workbook interface ,
		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(4);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		return stringCellValue;
		
	}
	
	public static String getcompany() throws InvalidFormatException, IOException {
		
		 file = new File(path);
		 workbook = new XSSFWorkbook(file); // workbook interface ,
		Sheet sheetAt = workbook.getSheetAt(0);
		Row row = sheetAt.getRow(5);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		return stringCellValue;
		
	}
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		getemail();
		getpassword();
		getfirstName();
		getlasttName();
		getdob();
		getcompany();
		
	}

}
