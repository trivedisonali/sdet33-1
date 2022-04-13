package com.crm.organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrgInfoPage;
import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ConstantPath;
import com.crm.genericutility.DriverUtility;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingNewOrganizationEmailOptOutSelectOptionIsEnabledOrNot_TC_9Test extends BaseClass {

	 
	@Test
	
	
		public void CreatingNewOrganizationEmailOptOutSelectOptionIsEnabledOrNot_TC_9Test() throws Throwable {
	
		//create pom class objects
		 CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
		 CreateNewOrganizationPage createneworgpage=new CreateNewOrganizationPage(driver);
         OrgInfoPage orginfo=new OrgInfoPage(driver);
         
         //to store variable
         
		
		
		
		
		
		//fetch data from property file
		FileUtility.initializePropertyFile(ConstantPath.PropertyFilePath);
		
		
		
		
		
		
		
		
		
		
		
		String url = FileUtility.fetchDataFromProperties("url");String userName = FileUtility.fetchDataFromProperties("userName");
		String password = FileUtility.fetchDataFromProperties("password");
		String browser = FileUtility.fetchDataFromProperties("browser");
		String excelPath = FileUtility.fetchDataFromProperties("excelPath");//
		String excelSheetName = FileUtility.fetchDataFromProperties("excelSheetName");
		String timeouts = FileUtility.fetchDataFromProperties("timeouts");
		long timeoutLong = Long.parseLong(timeouts);
		
		//to fetch data from excel files
		ExcelUtility.openExcel(ConstantPath.ExcelPath);
		String orgName = ExcelUtility.fetchData(excelSheetName, 9, 1);
		
		//random number
		int randomnumber = JavaUtility.generateRandomNumber(1000);
		
		////Launch the browser 
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		
		else {
			System.out.println("Browser not specified");
		}
		
		//basic configuration 
		DriverUtility.launchApllicationwithMaximize(driver, url, timeoutLong);
		
		 //Login to the application
		LoginPage login=new LoginPage(driver);
		login.createLoginPage(userName, password);
		
 	  /*driver.findElement(By.name("user_name")).sendKeys(userName);
 		driver.findElement(By.name("user_password")).sendKeys(password);
 		driver.findElement(By.id("submitButton")).click();*/
 		
 		//create organization
		HomePage homepage=new HomePage(driver);
		
 		driver.findElement(By.linkText("Organizations")).click();
 		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
 		String actOrgName=orgName+randomnumber;//concatwith orgname
 		driver.findElement(By.name("accountname")).sendKeys(actOrgName);
 		 WebElement checkbox = driver.findElement(By.name("emailoptout"));
 		 checkbox.click();
 		 
 		 if(checkbox.isSelected()) {
 			 System.out.println("Checkbox is selected");
 		 }
 		 else {
 			 System.out.println("Checkbox is not selected");
 		 }
 		 
 		//to save
  		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  		
  		//to logout
  		WebElement user = driver.findElement(By.xpath("//img[contains(@src,'/user.PNG')]"));
  		DriverUtility.moveToElement(driver, user);
        

  		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
  		
  		DriverUtility.closeBrowser(driver);
  		

  		
 		
 		
 		
		
		
		
		
		

	}

}
