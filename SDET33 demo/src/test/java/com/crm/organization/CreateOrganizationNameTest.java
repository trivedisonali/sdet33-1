package com.crm.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgInfoPage;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ConstantPath;
import com.crm.genericutility.DriverUtility;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Reporter;
public class CreateOrganizationNameTest extends BaseClass {
	

	@Test
	
	//instead of main method its @test
	 
	public void CreateOrganizationNameTest()  {
		
		//create the object for POM class
		 CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
		 CreateNewOrganizationPage createneworgpage=new CreateNewOrganizationPage(driver);
         OrgInfoPage orginfo=new OrgInfoPage(driver);
		
		
		//store variable
		String orgName=ExcelUtility.fetchData(FileUtility.fetchDataFromProperties("excelSheetName"), 9, 1)+JavaUtility.generateRandomNumber(1000);
		
		//click on organization tab
		//homepage=new HomePage(driver);
		homepage.OrganizationTab();
		
		//click on create organization
		createorgpage.createOrganization();
		
		//create org and save
		createneworgpage.createNewOrgPageWithOrgName(orgName);
		
		
		//verify org
      String actOrgName = orginfo.verifyOrgName();
		
      Assert.assertEquals(orgName, actOrgName);
		//if(orgName.equalsIgnoreCase(actOrgName))
		//{
			
			Reporter.log("Organization created successfully",true);
			
		//}	
		
	}
}
	    
	
	    
	   
	   
	   
	   
		
	
	
    
    
    
	

