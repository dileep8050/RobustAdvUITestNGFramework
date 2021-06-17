package com.learn.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.learn.driver.DriverManager;


public class LoginPageTest extends BaseTest{
	
	private LoginPageTest() {}

	
	@Test
	public void test1()
	{

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Failed images",Keys.ENTER);
	}

}
