package com.crm.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author HP
 *
 */

public class FileUtility {
	public static Properties properties;
	/**
	 * This method is used to initialize Property File
	 * @param path
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */

	public static void initializePropertyFile(String path) throws Throwable  {
		
		FileInputStream fis= new FileInputStream(path);
		 properties=new Properties();
		properties.load(fis);
		
		}
	/**
	 * This method is used to fetch Data From Properties
	 * @param key
	 * @return
	 */
	
	public static String fetchDataFromProperties(String key) {
		
		String value = properties.getProperty(key);
		return value;
	}
	

}
