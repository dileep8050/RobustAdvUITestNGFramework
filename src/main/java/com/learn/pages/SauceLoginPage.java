package com.learn.pages;

import org.openqa.selenium.By;

import com.learn.enums.WaitStrategy;
import com.learn.reports.ExtentLogger;

public class SauceLoginPage extends BasePage {
	
	private final By textboxUsername=By.xpath("//input[@id='user-name']");
	private final By textboxpassword=By.xpath("//input[@id='password']");
	private final By buttonlogin=By.xpath("//input[@id='login-button']");
	
	public SauceLoginPage enterUsername(String username)
	{
		ExtentLogger.pass("enter user name");
		sendKeys(textboxUsername, username, WaitStrategy.VISIBLE);
		return this;
	}
	public SauceLoginPage getPassword(String password)
	{
		ExtentLogger.pass("enter password");
		sendKeys(textboxpassword, password, WaitStrategy.VISIBLE);
		return this;	
	}
	
	public SauceHomePage clickLoginButton()
	{
		click(buttonlogin, WaitStrategy.CLICKABLE);
		ExtentLogger.pass("Clicked on login button");
		return new SauceHomePage();
	}
}
