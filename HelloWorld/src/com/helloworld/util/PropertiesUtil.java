package com.helloworld.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	  
	public Properties getInstance(String fileName){
		try {	
			fileName = "/"+fileName+".properties";	
			Properties prop = System.getProperties();
	       	InputStream in = this.getClass().getResourceAsStream(fileName);      
	       	prop.load(in);	       	
	       	return prop;
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		 }
	}
	 
}
