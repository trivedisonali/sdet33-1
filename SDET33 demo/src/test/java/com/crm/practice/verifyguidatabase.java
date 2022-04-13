package com.crm.practice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyguidatabase {

	public static void main(String[] args) {
		
		//**************VERIFY GUI WRT DATABASE*****************//
		
		// STORE DATA IN PROP FILE,LOGIN RMG YANTRA,ACCESS DATA IN PROPFILE AND SAVE PROJECT,THEN GET DATA
         // FROM DATABASE(PROJECT TABLE PRESENT) AND VERIFY IT
		
		
       Connection connection=null;
        try {
		
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		//GIVE CONNECTION FRST ITSLF
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
       
		FileInputStream fis=new FileInputStream("./src/test/resources/commondataTY.properties"); 
        Properties properties =new Properties();
        properties.load(fis);
        
        //the below are commondatas and commondatas are stored inside properties file and fetched from it
        String url = properties.getProperty("url");//fetching the url data from coomondataTY.properties file
        String userName = properties.getProperty("userName");//same as above
        String password = properties.getProperty("password");//same as above
        String browser = properties.getProperty("browser");//same as above
        String timeOuts = properties.getProperty("timeOuts");//same as above
        long timeOutslong = Long.parseLong(timeOuts); // typecasting from string to long
        
        WebDriver driver=null;//declaring it as null,needs to use it below
        
        //RUNTIME POLYMORPHISM EXAMPLE**************************
        if(browser.equalsIgnoreCase("chrome"))//using this we can use whichever browser needed
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
        
        
		//logging into rmg yantra and inspecting every element 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(timeOutslong, TimeUnit.SECONDS);
		 driver.get(url);
		 driver.findElement(By.id("usernmae")).sendKeys(userName);
		 driver.findElement(By.id("inputPassword")).sendKeys(password);
		 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 
		 driver.findElement(By.linkText("Projects")).click();
		 driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		 
		 String projname="TY_PROJ_004";//to verify,we are giving our projrct name,to compare
		
		 driver.findElement(By.name("projectName")).sendKeys(projname);
		 driver.findElement(By.name("createdBy")).sendKeys("Mohan");//we are providing using send keys.These are test case specific data,this has to be stored in excel,in further prgrm we wil  get to knw
		 WebElement dropdown = driver.findElement(By.name("//label[text()='Project Status ']/../select[@name='status']"));
		 
		 Select select=new Select(dropdown);//to handle dropdown
		 select.selectByVisibleText("Completed");
		 
		 driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		 
		 Statement statement=connection.createStatement();//to execute query we are taking statement
		 
		 //step4 execute query
		 //for fetch data(dql)
		 ResultSet result = statement.executeQuery("select* from project;");//fetching from project in database and storing in result
		 
		 while(result.next())
		 {
			 
			 String projectName=result.getString("project_name");//fetching project_name from database and storing it in variable
			 
			 if(projectName.equals(projname))//checking projname we gave and wot fetched from from DB are same
			 {
				 System.out.println("Data is stored in database");
			 }
			 
		 }
		 driver.close();
	}
	
	
	finally {
		
		//step5:close connection
		connection.close();
		System.out.println("connection is closed");
	}
	}
		 
		 
		

	}

