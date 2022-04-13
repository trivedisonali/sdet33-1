package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericutility.ExcelUtility;

public class AssertDataProviderwithExcel {
	
	@Test(dataProvider="dataprovider_usernamepassword")
	
	public void dataprovider_usernamepassword(String username,String password) {
		System.out.println(username+"======"+password);
	}
	
	
	
	
	
	@DataProvider
	
	public Object[][] dataprovider_usernamepassword() throws Throwable{
		
		
		ExcelUtility.openExcel("./src/test/resources/Multipledata.xlsx");
		Object[][] arr = ExcelUtility.fetchMultipleData("Multipledata");
		return arr;
		
		
	}
	

}
