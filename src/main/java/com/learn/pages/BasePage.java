package com.learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import com.learn.factories.ExpicitWaitFactory;

public class BasePage {

	protected void click(By by,WaitStrategy waitStrategy)
	{
		WebElement element=	ExpicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
	}

	protected void sendKeys(By by,String value,WaitStrategy waitStrategy)
	{
		WebElement element=	ExpicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);
	}

	protected String getPageTitle()
	{
		return DriverManager.getDriver().getTitle();
	}
}
