package com.crm.practice;

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

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ConstantPath;
import com.crm.genericutility.DriverUtility;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationNameDemoImp {
	
	
	 //SCENARIO:login to vtiger, click on organization,click on create organization,enter some name into Orgnaization textfield
     //click on save,verify it(checking whether its on org list page) & Logout
	
	 static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		//Step:1.fetch data from external file and store in variable
		
		FileUtility.initializePropertyFile(ConstantPath.PropertyFilePath);
	   
	    String url = FileUtility.fetchDataFromProperties("url");
	    String userName =FileUtility.fetchDataFromProperties("userName");
	    String password =FileUtility.fetchDataFromProperties("password");
	    String browser = FileUtility.fetchDataFromProperties("browser");
	    String excelPath=FileUtility.fetchDataFromProperties("excelPath");
        String excelSheetName =FileUtility.fetchDataFromProperties("excelSheetName");
	    String timeouts =FileUtility.fetchDataFromProperties("timeouts");
	    long timeoutLong = Long.parseLong(timeouts);
	    
	   
	    //Step:2:fetch data from excel file
	    ExcelUtility.openExcel(ConstantPath.ExcelPath);
	    String orgName= ExcelUtility.fetchData(excelSheetName, 9, 1);
	    
	    //Step:3:generate random number
	    
	    int randomnumber = JavaUtility.generateRandomNumber(1000);
	    String actOrgName=orgName+randomnumber;//GOT FROM GETSTRINGVALUE
	    
	  
	    
	   //Step2:Launch the browser
	    
	    
	    if(browser.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    
	    else if(browser.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    	
	    }
	    
	    else
	    {
	        System.out.println("Browser is not specified properly");
	    }
	    
	    
	    //Step:4:Do basic configuration  for browser
	    
	    DriverUtility.launchApllicationwithMaximize(driver, url, timeoutLong);
	   
	   
	    //Login to the application
	    LoginPage login=new LoginPage(driver);
	    login.createLoginPage(userName, password);
	   
		
		//create organization
	    CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
	    createorgpage.createOrganization();
	    
		
		//create new organization
	    CreateNewOrganizationPage createneworgpage=new CreateNewOrganizationPage(driver);
	    createneworgpage.CreateNewOrgPageWithOrgName(actOrgName);
		        
		
		
		//to verify the organization name is correct or not
		String expOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();//HERE WOT TO DO
		
		if(expOrgName.equalsIgnoreCase(actOrgName))
		{
			System.out.println("Organization name is created successfully");
			
			wk.getSheet(excelSheetName).getRow(randomnumber).getCell(randomnumber).setCellValue("Pass");
			FileOutputStream fos=new FileOutputStream(excelPath);
			wk.write(fos);
		}
		wk.close();
		
	    
		//to logout
		HomePage homepage=new HomePage(driver);
		homepage.Logout(driver);
		
		DriverUtility.closeBrowser(driver);
			
	}
	
	
	
    
    
    
	
}
