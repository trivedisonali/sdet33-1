package com.crm.organization;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.OrgInfoPage;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ConstantPath;
import com.crm.genericutility.DriverUtility;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgNamewithDropDownTest extends BaseClass{
	

	@Test
	public void CreateOrgNamewithDropDownTest() {
		
		//create pom class object
		 CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
		 CreateNewOrganizationPage createneworgpage=new CreateNewOrganizationPage(driver);
         OrgInfoPage orginfo=new OrgInfoPage(driver);
         
         //store the variables
         String orgName=ExcelUtility.fetchData(FileUtility.fetchDataFromProperties("excelSheetName"), 12, 1)+JavaUtility.generateRandomNumber(1000);
         String industry=ExcelUtility.fetchData(FileUtility.fetchDataFromProperties("excelSheetName"), 12, 2);
         String type=ExcelUtility.fetchData(FileUtility.fetchDataFromProperties("excelSheetName"), 12, 3);
         
        //click on organization tab in homepage
         homepage.OrganizationTab();
         
         //click on + in organization page
         createorgpage.createOrganization();
         
         //click on newcreateorg create new organizationpage
         createneworgpage.createNewOrgPageWithOrgName(orgName);
         createneworgpage.cretaeNewOrgpagewithDropDownIndustry(orgName, industry);
         createneworgpage.cretaeNewOrgpagewithDropDownType(type);
         
         
       //to verify the organization name,industry and type is correct or not
         
         String actOrgName=orginfo.verifyOrgName();
         String actIndusry=orginfo.verifyIndustrydropdown();
         String actType=orginfo.verifyTypedropdown();
         
         
         
         if(orgName.equalsIgnoreCase(actOrgName)&&industry.equalsIgnoreCase(actIndusry)&&type.equalsIgnoreCase(actType))
  		{
  			System.out.println("Organization is created successfully with industry and type");
  			
     }
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        
         
     
 		
 		
 	