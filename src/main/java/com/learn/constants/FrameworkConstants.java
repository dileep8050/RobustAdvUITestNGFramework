package com.learn.constants;

public final class FrameworkConstants {

private FrameworkConstants(){};
	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH+"/executables/chromedriver.exe";
	private static final String FIREFOXDRIVERPATH = RESOURCEPATH+"/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/extent-report-output/index.html";
	private static final String EXCELPATH = RESOURCEPATH+"/excel/testdataexecution.xlsx";
	private static final String RUNMANAGERSHEET ="RUNMANAGER";
	private static final String ITERATIONDATASHEET ="DATA";
	

	private static final int EXPLICITWAIT=10;
	
	public static String getExtentReportPath() {
		return EXTENTREPORTPATH;
	}
	
	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getFirefoxDriverPath() {
		return FIREFOXDRIVERPATH;
	}
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}
	public static String getExcelPath() {
		return EXCELPATH;
	}
	
	public static String getRunManagerSheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationDataSheet() {
		return ITERATIONDATASHEET;
	}

}
