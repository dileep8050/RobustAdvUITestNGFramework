package com.learn.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.learn.driver.DriverManager;

public final class HomepageTest extends BaseTest{
	
	private HomepageTest() {}
	
	@Test
	public void test2()
	{

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("super man",Keys.ENTER);

	}
	@Test
	public void test3()
	{

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("33333",Keys.ENTER);

	}
	
	@Test
	public void test4()
	{

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("4444",Keys.ENTER);

	}
	
}
