package com.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerDatabase {

	public static void main(String[] args) throws Throwable {
		
		
		Connection connection=null;String url=null;String username=null;String password=null;String lastname=null;
		
		try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet33","root","root");
		
		Statement statement = connection.createStatement();
		
		 ResultSet result = statement.executeQuery("Select* from vtiger;");
		 
		
		 while(result.next())
		 {
			 url=result.getString(1);
			 username=result.getString(2);
			 password=result.getString(3);
			 lastname=result.getString(4);
			 
		 }
		
		 
		    WebDriverManager.chromedriver().setup();
		    WebDriver driver=new ChromeDriver();
		    driver.get(url);
		    driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
			
			String actResult=driver.findElement(By.id("dtlview_Last Name")).getText();
			if(actResult.equals(lastname))
			{
				System.out.println("Test case pass");
			}
			
			Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'/user.PNG')]"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			
		}
		
		finally {
			connection.close();
			System.out.println("Connection is closed");
		}
		

		
		
		
	}

}
