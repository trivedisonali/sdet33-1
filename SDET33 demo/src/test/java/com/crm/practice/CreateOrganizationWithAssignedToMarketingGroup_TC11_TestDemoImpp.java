package com.crm.practice;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LogOut;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationHomePage;
import com.crm.genericutility.ConstantPath;
import com.crm.genericutility.DriverUtility;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithAssignedToMarketingGroup_TC11_TestDemoImpp{

	   static WebDriver driver;//if u not give here**********go down
	public static void main(String[] args) throws Throwable {
		
		
		//to fetch data from properties file
		
		FileUtility.initializePropertyFile(ConstantPath.PropertyFilePath);
		
		String url = FileUtility.fetchDataFromProperties("url");
		String userName = FileUtility.fetchDataFromProperties("userName");
		String password = FileUtility.fetchDataFromProperties("password");
		String browser = FileUtility.fetchDataFromProperties("browser");
		String excelPath = FileUtility.fetchDataFromProperties("excelPath");//
		String excelSheetName = FileUtility.fetchDataFromProperties("excelSheetName");
		String timeouts = FileUtility.fetchDataFromProperties("timeouts");
		long timeoutLong = Long.parseLong(timeouts);
		
		//to fetch data from excel files
		
		ExcelUtility.openExcel(ConstantPath.ExcelPath);
		
		String OrgName = ExcelUtility.fetchData(excelSheetName,18,1);
		System.out.println(OrgName);
		String ActualassignTo = ExcelUtility.fetchData(excelSheetName, 18, 2);
		System.out.println(ActualassignTo);
		
		//generate random number
		int randomnumber = JavaUtility.generateRandomNumber(1000);
		String actOrgName=OrgName+randomnumber;//concatwith orgname
		
		
		//Launch the browser                    ********here declare WebDriver driver=null,then every where driver is there eg.find elements we have to give,driver=driver.findelements....
		if(browser.equalsIgnoreCase("chrome")) {        //so instead go to webdriver utilitit lauch and give webdriver driver and return also
			
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
		
		//Basic configuraion for browser
		DriverUtility.launchApplication(driver, url, timeoutLong);
        
		
		
		 //Login to the application
		LoginPage login=new LoginPage(driver);
		login.createLoginPage(userName, password);
		/*driver.findElement(By.name("user_name")).sendKeys(userName);
 		driver.findElement(By.name("user_password")).sendKeys(password);
 		driver.findElement(By.id("submitButton")).click();*/
 		
 		//create organization
		HomePage homepage=new HomePage(driver);
		homepage.OrganizationTab();
		//driver.findElement(By.linkText("Organizations")).click(); 
 		
		
		CreateOrganizationPage orgpage=new CreateOrganizationPage(driver);
		orgpage.createOrganization();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		CreateNewOrganizationPage createneworgpage=new CreateNewOrganizationPage(driver);
		createneworgpage.CreateNewOrgPagewithOrgNameAssignTo(actOrgName);
		//driver.findElement(By.name("accountname")).sendKeys(actOrgName);
 		//driver.findElement(By.xpath("//input[@value='T']")).click();*/  //SAVE LAST INBTWN ASSIGNTO,HOWTO DO IN POM
		
 		
		
		//to verify
	    WebElement expAssignTo = driver.findElement(By.name("assigned_group_id"));
		Select select=new Select(expAssignTo);
 		List<WebElement> options = select.getAllSelectedOptions();
 		for (WebElement option : options) {
 			
 			
 			if(option.getText().equalsIgnoreCase(ActualassignTo)) { //is selected???
 				
 				
 				option.click();
 				break;
 			}
 			
 			
 			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 			
			
		}

        //to logout from application
 		
 		homepage.Logout(driver);
 		
 		
 		//to close the browser
 		DriverUtility.closeBrowser(driver);
 		
 		
 		
 		
		
		
		
		
		
		
		
		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		

	}

}
