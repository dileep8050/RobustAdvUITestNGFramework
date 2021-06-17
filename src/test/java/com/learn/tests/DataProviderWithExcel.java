package com.learn.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {
	
	@Test(dataProvider = "getData1")
	public void test1(Map<String,String> map) {
		System.out.println(map.get("Username")+", "+map.get("Password")+", "+map.get("Firstname")+", "+map.get("Lastname"));	
	}

	@DataProvider
	public Object[] getData1() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rowNum=sheet.getLastRowNum();
		System.out.println(rowNum);
		int lastColumn=sheet.getRow(0).getLastCellNum();
		System.out.println(lastColumn);
		
		Object[] data=new Object[rowNum];
		Map<String, String> map;
		
		for(int i=1;i<=rowNum;i++)
		{
			map=new HashMap<String, String>() ;
			for(int j=0;j<lastColumn;j++)
			{
				
				String key=sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1]=map;
			}
		}
		return data;
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rowNum=sheet.getLastRowNum();
		System.out.println(rowNum);
		int lastColumn=sheet.getRow(0).getLastCellNum();
		System.out.println(lastColumn);
		
		Object[][] data=new Object[rowNum][lastColumn];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<lastColumn;j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
