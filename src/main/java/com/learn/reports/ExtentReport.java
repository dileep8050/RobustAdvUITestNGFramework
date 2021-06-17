package com.learn.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.learn.constants.FrameworkConstants;

public final class ExtentReport {
	private ExtentReport() {}
	
	private static ExtentReports extent;
	
	
	public static void initExtentReport()
	{
		if(Objects.isNull(extent))
		{
		extent =new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportPath())
				.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.CATEGORY,ViewName.TEST,ViewName.AUTHOR}).apply();
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Extent Automation Report");
		spark.config().setDocumentTitle("UI Automation Report");
		spark.config().setReportName("Dileep");
		}
		
	}
	public static void flushReports()
	{
		if(Objects.nonNull(extent))
		{
		extent.flush();
		}
		ExtentManager.unload();
	}
	public static void createTest(String testName)
	{
		ExtentManager.setExtentTest(extent.createTest(testName));
	}
	public static void addgroups(String[] groups)
	{
		for(String temp:groups) {
			ExtentManager.getExtentTest().assignCategory(temp);
		}
	}

}
