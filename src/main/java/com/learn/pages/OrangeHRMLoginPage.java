package com.learn.pages;

import org.openqa.selenium.By;

import com.learn.enums.WaitStrategy;



public class OrangeHRMLoginPage extends BasePage {
	
	private final By textboxUsername=By.id("txtUsername");
	private final By textboxPassword=By.id("txtPassword");
	private final By buttonLogin=By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUsername(String username)
	{
		sendKeys(textboxUsername, username,WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password)
	{
		sendKeys(textboxPassword, password,WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMHomePage clickLogin()
	{
		click(buttonLogin,WaitStrategy.CLICKABLE);
		return new OrangeHRMHomePage();
	}
	
	public String getTitle()
	{
		return getPageTitle();
	}
}
