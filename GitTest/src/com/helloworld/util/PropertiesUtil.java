package com.helloworld.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
	    private static String username;   
	    private static String password;   
	  
	    static {   
	        Properties prop = new Properties();   
	        InputStream in = Object.class.getResourceAsStream("mail.properties");   
	        try {   
	            prop.load(in);  
	            username = prop.getProperty("username").trim();   
	            password = prop.getProperty("password").trim();   
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        }   
	    }

		public static String getUsername() {
			return username;
		}

		public static void setUsername(String username) {
			PropertiesUtil.username = username;
		}

		public static String getPassword() {
			return password;
		}

		public static void setPassword(String password) {
			PropertiesUtil.password = password;
		}   
	  
	    
	 
}
