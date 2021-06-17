package com.learn.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learn.pages.OrangeHRMLoginPage;


public final class OrangeHRMTest extends BaseTest {
	
	private OrangeHRMTest() {}
	
	@Test
	public void loginLogoutTest()
	{

		//Method Chaining
		
		String loginpageTitle=new OrangeHRMLoginPage()
							.enterUsername("Admin").enterPassword("admin123").clickLogin()
							.clickWelcome().clickLogout()
							.getTitle();
		Assert.assertEquals(loginpageTitle, "OrangeHRM");
		
		//normal style
		/*
		OrangeHRMLoginPage ohlp=new OrangeHRMLoginPage();
		ohlp.enterUsername("Admin");
		ohlp.enterPassword("admin123");
		ohlp.clickLogin();
		
		OrangeHRMHomePage ohhp=new OrangeHRMHomePage();
		ohhp.clickWelcome();
		ohhp.clickLogout();
		
		String loginpageTitle=ohlp.getTitle();
		*/
	}
}
