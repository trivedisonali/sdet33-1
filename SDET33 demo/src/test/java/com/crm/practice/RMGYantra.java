package com.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

//DATABASE WITH RESPECT TO GUI

public class RMGYantra {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub
		Connection connection=null;String project_id=null;String created_by=null;String created_on=null;String project_name=null;String status=null;String team_size=null;
		
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
        Statement statement = connection.createStatement();
		
		int result = statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size)values('TY_PROJ_004','Reshma','11/11/2022','SDET33','completed','4')");
		if(result==1)
		{
			System.out.println("rows got changed");
		}
		else {
			System.out.println("rows doesnt got changed");
		}
		
		
		
			
	     WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://localhost:8084/");
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 driver.findElement(By.linkText("Projects")).click();
		 String expectedresult="TY_PROJ_004";//DATABASE
		 String actualresult = driver.findElement(By.xpath("//td[text()='TY_PROJ_004']")).getText();
		 if(actualresult.equals(expectedresult))
		 {
			 System.out.println("test script is pass");
			 
		 }
		 
		 //java.sql.SQLIntegrityConstraintViolationException another method
		 
			
			
			
			
		}
	}


