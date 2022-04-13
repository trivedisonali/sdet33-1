package com.crm.practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGyantra2 {
	
	//GUI WITH RESPECT TO DATABASE

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;String project_id=null;String created_by=null;String created_on=null;String project_name=null;String status=null;String team_size=null;
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.get("http://localhost:8084/");
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 driver.findElement(By.linkText("Projects")).click();//????
		 driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		 driver.findElement(By.name("projectName")).sendKeys("TY_PROJ_005");
		 driver.findElement(By.name("createdBy")).sendKeys("Deepak");
		 
		WebElement dropdown = driver.findElement(By.name("//label[text()='Project Status ']/../select[@name='status']"));
		dropdown.click();
		
		Select select=new Select(dropdown);
		select.selectByVisibleText("Completed");
		 driver.findElement(By.name("createdBy")).click();
		
		 
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select* from project;");
		while(result.next())
		{
			project_id=result.getString(1);
			created_by=result.getString(2);
			created_on=result.getString(3);
			project_name=result.getString(4);
			status=result.getString(5);
			team_size=result.getString(6);
		}
		
		connection.close();
		
		}

}
