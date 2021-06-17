package com.learn.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.learn.enums.ConfigProperties;
import com.learn.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	private Driver() {}

	public static void initDriver(String browser)
	{
		if(Objects.isNull(DriverManager.getDriver())){
			if(browser.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				//System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxDriverPath());
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}
	
	public static void quitdriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
