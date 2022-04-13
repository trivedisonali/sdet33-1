package com.crm.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {

	public static void main(String[] args) throws IOException {
		
		//convert physical file into java readable object 
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		
		//create object of properties
		Properties properties=new Properties();
		
		//load all the keys
		properties.load(fis);
		
		
		//fetch the data 
		String url = properties.getProperty("url");
		System.out.println(url);
		String userName = properties.getProperty("userName");
		System.out.println(userName);
	
		
		

	}

}
