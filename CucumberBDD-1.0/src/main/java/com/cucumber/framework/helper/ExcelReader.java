package com.cucumber.framework.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.pageobjects.BasePage;

public class ExcelReader extends BasePage implements BaseObjects {

	protected  File file;
	protected  String columnName;
	protected  FileOutputStream fileOutputStream;
	protected  String path = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\TestData.xlsx";

	public String getTestData(String argument) throws IOException {
		String key = null;
		String value = null;
		String argumentValue = null;
		columnName = null;		
		columnName = argument;		
		testdatReader = new HashMap<>();	
		try {
			FileInputStream fisinputstream = new FileInputStream(readTestDataFile());
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fisinputstream);
			XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");

			int firstRowNum = xssfSheet.getFirstRowNum();
			int lastrowNum = xssfSheet.getLastRowNum();
			int numberofColumn = xssfSheet.getRow(firstRowNum).getLastCellNum();

			for (int column = 0; column < numberofColumn; column++) {
				key = xssfSheet.getRow(firstRowNum).getCell(column).getStringCellValue();
				for (int row = 1; row <= lastrowNum; row++) {
					String testCaseNum = null;
					testCaseNum = xssfSheet.getRow(row).getCell(0).getStringCellValue();
					if (testCaseNum.trim().equalsIgnoreCase(testCaseId.trim())) {
						if (key.equalsIgnoreCase(argument)) {
							value = xssfSheet.getRow(row).getCell(column).getStringCellValue();
							testdatReader.put(key, value);
							argumentValue = null;
							argumentValue = testdatReader.get(key);
							break;
						}
					}
				}
			}
			return argumentValue;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void readTestCaseID(String testCase) {
		testCaseId = null;
		if (!(testCase == null)) {
			testCaseId = testCase;
		} 
	}

	public File readTestDataFile() {
		try {
			file = new File(path);
			if (!file.exists())
				Assert.fail("TestData file does not exists in " + System.getProperty("user.dir")
						+ "\\src\\main\\resources\\testdata\\" + "****directory");
			return file;
		} catch (Exception e) {
			return null;
		}
	}
}
