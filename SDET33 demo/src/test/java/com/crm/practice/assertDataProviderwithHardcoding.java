package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class assertDataProviderwithHardcoding {
	
	@Test(dataProvider="dataprovider_company")

	
	public void dataprovider_company(String company,int year){
		
	System.out.println(company+"====="+year);	
	
	}
	
	@DataProvider
	public Object[][] dataprovider_company(){
		Object[][] arr=new Object[5][2];
		
		arr[0][0]="TestYantra";
		arr[0][1]=2022;
		
		arr[1][0]="Infosys";
		arr[1][1]=2023;
		
		arr[2][0]="TCS";
		arr[2][1]=2024;
		
		arr[3][0]="Oracle";
		arr[3][1]=2025;
		
		arr[4][0]="Accenture";
		arr[4][1]=2026;
		
		return arr;
		
		
		
	}
}
