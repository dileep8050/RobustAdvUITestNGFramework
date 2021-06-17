package com.learn.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.learn.enums.ConfigProperties;
import com.learn.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count=0;
	private int retries=1;
	public boolean retry(ITestResult result) {

			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			{
				if(count<retries)
				{
					count++;
					return true;
				}
			}
		return false;
	}

}
