package com.learn.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.learn.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {}
	
	@BeforeMethod(alwaysRun = true)
	protected void setUp()
	{
		Driver.initDriver("firefox");
	}
	
	@AfterMethod(alwaysRun = true)
	protected void tearDown()
	{
		Driver.quitdriver();
	}

}
