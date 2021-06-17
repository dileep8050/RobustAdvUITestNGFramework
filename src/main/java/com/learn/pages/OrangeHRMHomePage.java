package com.learn.pages;

import org.openqa.selenium.By;

import com.learn.enums.WaitStrategy;

public class OrangeHRMHomePage extends BasePage {
	
	private final By linkWelcome=By.id("welcome");
	private final By linkLogout=By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome()
	{
		click(linkWelcome,WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout()
	{
		
		click(linkLogout,WaitStrategy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}
	

}
