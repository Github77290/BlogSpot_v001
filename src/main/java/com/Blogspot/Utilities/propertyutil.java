package com.Blogspot.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyutil {
	static Properties prop;
	public static void intilizeproperty() throws IOException {
		File file=new File("..\\Blogspot\\Resources\\config\\Propertyfile");
		FileInputStream fis=new FileInputStream(file);
		
		 prop=new Properties();
		prop.load(fis);
		
	}
	public static String readproperty(String key) {
		return prop.getProperty(key);
	}

}
