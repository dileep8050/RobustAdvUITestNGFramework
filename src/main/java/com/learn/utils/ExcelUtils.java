package com.learn.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.learn.constants.FrameworkConstants;
import com.learn.exceptions.FrameworkException;
import com.learn.exceptions.InvalidFilePathException;

public final class ExcelUtils {

	private ExcelUtils() {}

	public static List<Map<String,String>> getTestDetails(String sheetName){
		List<Map<String,String>> list = null;

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FrameworkConstants.getExcelPath());
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);

			int lastRowNum=sheet.getLastRowNum();
			int lastColumn=sheet.getRow(0).getLastCellNum();

			Map<String,String> map=null;
			list=new ArrayList<Map<String,String>>();
			for(int i=1;i<=lastRowNum;i++) {
				map=new HashMap<String,String>();
				for(int j=0;j<lastColumn;j++) {
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} 
		catch (FileNotFoundException e) {
			throw new InvalidFilePathException("Excel file you trying to read is not available");
		}
		catch (IOException e) {
			throw new FrameworkException("Some IO exception is happened while reading the Excel file");
		}
		finally {
			try {
				if(Objects.nonNull(fis)) {
					fis.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;

	}
}
