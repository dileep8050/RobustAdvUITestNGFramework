package com.learn.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.learn.enums.ConfigProperties;
import com.learn.utils.PropertyUtils;
import com.learn.utils.ScreenshotUtils;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	/*
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	*/
	public static void fail(Throwable throwable) {
		ExtentManager.getExtentTest().fail(throwable);	
	}
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}
	
	public static void pass(String message,boolean isScreenshotNeeded){
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
		{
		ExtentManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else
		{
			pass(message);
		}
	}
	
	public static void fail(Throwable throwable,boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
		{
		ExtentManager.getExtentTest().fail(throwable,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else
		{
			fail(throwable);
		}
	}	
}
