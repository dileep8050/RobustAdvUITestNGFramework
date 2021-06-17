package com.learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.learn.driver.DriverManager;

public class SauceHomePage {
	
	private final By cart=By.xpath("//*[@id='shopping_cart_container']/a");
	
	public WebElement getcart()
	{
		return DriverManager.getDriver().findElement(cart);
	}

}
