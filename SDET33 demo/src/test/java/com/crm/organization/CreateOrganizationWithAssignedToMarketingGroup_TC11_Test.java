package com.crm.organization;


import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithAssignedToMarketingGroup_TC11_Test extends BaseClass{

	  
	 @Test
		
		 public void CreateOrganizationWithAssignedToMarketingGroup_TC11Test() {
	     
		 //cretae pom class object
		 CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
		 CreateNewOrganizationPage createneworgpage=new CreateNewOrganizationPage(driver);
         OrgInfoPage orginfo=new OrgInfoPage(driver);
         
         //store the variable
         String orgName=ExcelUtility.fetchData(FileUtility.fetchDataFromProperties("excelSheetName"), 18, 1)+JavaUtility.generateRandomNumber(1000);
		 String actualAssignTo=ExcelUtility.fetchData(FileUtility.fetchDataFromProperties("excelSheetName"), 18, 2);
		 System.out.println(orgName);
		 System.out.println(actualAssignTo);
		 
		 
		 //click on organization tab
		 homepage.OrganizationTab();
		 
		 //click on create organization
		 createorgpage.createOrganization();
		 
		 //create org and save
		 createneworgpage.createNewOrgPagewithOrgNameAssignTo(orgName);
		 
		 //to verify org name
		 String actOrgname = orginfo.fetchOrgName();
		 
		 if(orgName.equalsIgnoreCase(actOrgname)) {
			 
		 Reporter.log("Organization name created successfully", true);
		 }
		 
		 //to verify assignto
	
	  /*  WebElement expAssignTo = driver.findElement(By.name("assigned_group_id"));
		Select select=new Select(expAssignTo);
 		List<WebElement> options = select.getAllSelectedOptions();
 		for (WebElement option : options) {
 			
 			
 			if(option.getText().equalsIgnoreCase(ActualassignTo)) { //is selected???
 				
 				
 				option.click();
 				break;
 			}*/
 			

	}

}
