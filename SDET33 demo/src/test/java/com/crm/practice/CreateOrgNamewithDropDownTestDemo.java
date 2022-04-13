package com.crm.practice;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.crm.genericutility.ConstantPath;
import com.crm.genericutility.DriverUtility;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgNamewithDropDownTestDemo {
static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		//login to vtiger,click on organization,click on create organization,enter some name into Orgnaization textfield,click on industry dropdown and select Education
		//click on Type dropdown and select Analyst,click on Save,verify Organiaztion name, industry andType then Logout
		
		
		//Step:1.fetch data from external file and store in variable
		
		FileUtility.initializePropertyFile(ConstantPath.PropertyFilePath);
         //FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
         //Properties properties=new Properties();
         //properties.load(fis);
		
		String url = FileUtility.fetchDataFromProperties("url");
		// String url = properties.getProperty("url");
				
	     String userName=FileUtility.fetchDataFromProperties("userName");
         //String userName = properties.getProperty("userName");
		
		String password=FileUtility.fetchDataFromProperties("password");
        // String password = properties.getProperty("password");
		
		String browser=FileUtility.fetchDataFromProperties("browser");
         //String browser = properties.getProperty("browser");
		
		String excelPath=FileUtility.fetchDataFromProperties("excelPath");
         //String excelPath=properties.getProperty("excelPath");
		
		String excelSheetName=FileUtility.fetchDataFromProperties("excelSheetName");
        //String excelSheetName = properties.getProperty("excelSheetName");
		
		String timeouts=FileUtility.fetchDataFromProperties("timeouts");
         //String timeouts = properties.getProperty("timeouts");
		
		long timeoutLong =  Long.parseLong(timeouts);
		
        
         
        
         
         //to fetch data from excel
         ExcelUtility.openExcel(ConstantPath.ExcelPath);
         
         String orgName=ExcelUtility.fetchData(excelSheetName,12,1);
        // String orgName = wk.getSheet(excelSheetName).getRow(12).getCell(1).getStringCellValue();
         
         String industry=ExcelUtility.fetchData(excelSheetName, 12, 2);     
         //String industry = wk.getSheet(excelSheetName).getRow(12).getCell(2).getStringCellValue();
        
          String type= ExcelUtility.fetchData(excelSheetName, 12, 3);
         //String type =wk.getSheet(excelSheetName).getRow(12).getCell(3).getStringCellValue();
         
          
          
          
          //generate random number,this will add random number to org name and make it execute(otherwise it will show name repeated)
          int randomnumber = JavaUtility.generateRandomNumber(1000);
         // Random ran =new Random();
          //int randomnumber = ran.nextInt(1000);
          
         
         //Step:2:Launch the Browser
         
  
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
         
         //Step:3:Basic configuration for browser
         
         
        //driver.manage().window().maximize();
 	    //driver.manage().timeouts().implicitlyWait(timeoutLong,TimeUnit.SECONDS);
       //driver.get(url);
 	    //open the url and navigate to the application
       DriverUtility.launchApllicationwithMaximize(driver,url, timeoutLong);
         
 	    
 	    
 	    //Login to the application
 	    driver.findElement(By.name("user_name")).sendKeys(userName);
 		driver.findElement(By.name("user_password")).sendKeys(password);
 		driver.findElement(By.id("submitButton")).click();
 		
 		//create organization
 		driver.findElement(By.linkText("Organizations")).click();
 		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
 		String actOrgName=orgName+randomnumber;//concatwith orgname
 		driver.findElement(By.name("accountname")).sendKeys(actOrgName);
 		
  		//create industry dropdown
 		WebElement industryDropDown = driver.findElement(By.name("industry"));
 		DriverUtility.select(industry, industryDropDown);
 		/*Select select=new Select(industryDropDown);
 		select.selectByVisibleText(industry);*/
 		
 		//create type dropdown
 		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
 		DriverUtility.select(type, typeDropDown);
 		/*Select select1=new Select(typeDropDown);
 		select1.selectByVisibleText(type);*/
 		
 		
 		//to save
 		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 		
 		
 		//to verify the organization name,industry and type is correct or not
 		String expOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
 		String expIndName = driver.findElement(By.id("dtlview_Industry")).getText();
 		String expTypeName = driver.findElement(By.id("dtlview_Type")).getText();
 		
 		if(expOrgName.equalsIgnoreCase(actOrgName)&&expIndName.equalsIgnoreCase(industry)&&expTypeName.equalsIgnoreCase(type))
 		{
 			System.out.println("Organization is created successfully with industry and type");
 			
 			ExcelUtility.writeDataInExistingRow(excelPath, excelSheetName, 12, 4, "PASS");
 			//wk.getSheet(excelSheetName).getRow(12).createCell(4).setCellValue("pass");
 			//FileOutputStream fos=new FileOutputStream(excelPath);//to write data
 			//wk.write(fos);//to write and flush the data...write() abstract come from workbook interface
 			//wk.close();
 			ExcelUtility.closeExcel();
 		}
 		
 		//to logout
 		
 		WebElement user = driver.findElement(By.xpath("//img[contains(@src,'/user.PNG')]"));
 		
 		DriverUtility.moveToElement(driver, user);
 		/*Actions action=new Actions(driver);
 		action.moveToElement(user).perform();*/
 		
 		driver.findElement(By.linkText("Sign Out")).click();
 		
 		DriverUtility.closeBrowser(driver);
 		//driver.quit();
 
 	

	}

}
