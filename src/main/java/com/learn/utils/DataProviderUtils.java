package com.learn.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.learn.constants.FrameworkConstants;

public final class DataProviderUtils {

	private static List<Map<String,String>> list=new ArrayList<Map<String,String>>();
	@DataProvider
	public static Object[] getData(Method m) {
		String testname=m.getName();
		if(list.isEmpty()) {
			list=ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
		}

		List<Map<String,String>> smallList=new ArrayList<Map<String,String>>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) && 
					list.get(i).get("execute").equalsIgnoreCase("yes")) 
			{
				smallList.add(list.get(i));
			}
		}
		return smallList.toArray();
	}
}
