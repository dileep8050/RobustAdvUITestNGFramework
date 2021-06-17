package com.learn.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.learn.constants.FrameworkConstants;
import com.learn.enums.ConfigProperties;
import com.learn.exceptions.PropertyFileUseageException;


public final class PropertyUtils {
	
	private PropertyUtils () {}
	public static String get(ConfigProperties keyFromEnum)
	{
		Properties prop=new Properties();
		
			try {
				FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
				prop.load(fis);
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		
			//Checking input key value is null or not in the same way check the output value also null or not
		String key=keyFromEnum.name().toLowerCase();
		
		if (Objects.isNull(prop.getProperty(key))|| Objects.isNull(key))
		{
			throw new PropertyFileUseageException("Property name or Property values "+key+" is not found. Please check config.properties");
		}
		return prop.getProperty(key);
	}

}
