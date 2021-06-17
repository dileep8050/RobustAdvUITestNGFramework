package com.learn.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learn.pages.SauceHomePage;
import com.learn.pages.SauceLoginPage;
import com.learn.reports.ExtentLogger;
import com.learn.utils.DataProviderUtils;


public final class SauceTest extends BaseTest{
	private SauceTest() {}
	
	@Test(dataProvider ="getData" ,groups= {"reg","sanity"},dataProviderClass = DataProviderUtils.class)
	public void loginLogoutSaucePortal(Map<String,String> data)
	{
		//ExtentLogger.info("loginLogoutSaucePortal test started with test data Username: "+username+" and Password : "+password);
		SauceLoginPage slp=new SauceLoginPage();
		slp.enterUsername(data.get("username")).getPassword(data.get("password")).clickLoginButton();
		SauceHomePage shp=new SauceHomePage();
		shp.getcart().isDisplayed();	
	}
	/*
	@DataProvider(name="LoginDetails",parallel=true)
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="standard_user";
		obj[0][1]="secret_sauce";
		
		obj[1][0]="problem_user";
		obj[1][1]="sdfasfdas";
		
		obj[2][0]="performance_glitch_user";
		obj[2][1]="secret_sauce";
		return obj;
	}*/
	
	@Test(groups= {"smoke"},dataProvider ="getData",dataProviderClass = DataProviderUtils.class)
	public void test3(Map<String,String> data)
	{
		SauceLoginPage slp=new SauceLoginPage();
		slp.enterUsername(data.get("username")).getPassword(data.get("password")).clickLoginButton();
		SauceHomePage shp=new SauceHomePage();
		shp.getcart().isDisplayed();
	}
	
	@Test(groups= {"smoke"})
	public void test4()
	{
	ExtentLogger.info("Using annotatin abc");
	}
	
	@Test(groups= {"reg"})
	public void test5()
	{
	ExtentLogger.info("Using annotatin reg");
	Assert.assertTrue(false);
	}
	
}
