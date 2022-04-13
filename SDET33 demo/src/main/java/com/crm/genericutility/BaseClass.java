package com.crm.genericutility;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public HomePage homepage;  //initialize here in baseclass in bfr method or give in directly in testng
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite (groups={"smoke","regression"})                          //open the database
	public void openDataBase() throws Throwable{
		
		FileUtility.initializePropertyFile(ConstantPath.PropertyFilePath);
		ExcelUtility.openExcel(ConstantPath.ExcelPath);
		
		//DataBaseUtility.getMySqlDatabaseConnection(ConstantPath.dburl,
				//FileUtility.fetchDataFromProperties("dbusername"),
				//FileUtility.fetchDataFromProperties("dbpassword"));
		
		}
	
	 //launchBrowser
	
	//@Parameters(value="browser")                         (@Parameters(value="browser") and (String browser)   if using in xml,ordinary run comment it out)  
	@BeforeClass                       
	public void  launchBrowser() {
		
		String browser=FileUtility.fetchDataFromProperties("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			DriverUtility.println("Browser is nor specified properly", true);
		}
		
		
		DriverUtility.launchApllicationwithMaximize(driver, 
				FileUtility.fetchDataFromProperties("url"),
				JavaUtility.covertStringtoLong(FileUtility.fetchDataFromProperties("timeouts")));
		sdriver=driver;
		
		}
	
	@BeforeMethod(groups= {"smoke","regression"})
	public void loginToApplication() throws Throwable {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.createLoginPage(FileUtility.fetchDataFromProperties("userName"), FileUtility.fetchDataFromProperties("password"));
	   	    
	   	    homepage = new HomePage(driver);
	}
	
	@AfterMethod(groups={"smoke","regression"})
	public void logoutFromApplication() throws Exception {
		
		homepage.Logout(driver);
		ExcelUtility.closeExcel();
		
	}
	
	@AfterClass(groups={"smoke","regression"})
	public void closeBrowser() {
		
	  DriverUtility.closeBrowser(driver);
	}
	
	@AfterSuite(groups={"smoke","regression"})
	public void closeDBConnection() throws Exception {
		//DataBaseUtility.closeDatabaseConnection();
		
	}
	
         
	
	

}
