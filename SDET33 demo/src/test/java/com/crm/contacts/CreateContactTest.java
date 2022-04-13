package com.crm.contacts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {
	//PRGRM WITHOUT USING DATA FROM EXCEL SHEET SIMPLE PRGRM
	
	public static void main(String[] args) throws Exception {
	
	//set the driver executable path
	WebDriverManager.chromedriver().setup();
	
	//instanciate the browser specific class 
	WebDriver driver=new ChromeDriver();
	
	//maximize the empty browser
	driver.manage().window().maximize();
	
	//provide implicit wait
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	
	//pass the main url
	driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	
	//login page
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("manager");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	
	//homepage
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("Reshma");
	driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
	Thread.sleep(2000);
	
	String actualcontact="Reshma";//CHECK WITH VERI PAGE
	String expectedcontact=driver.findElement(By.id("dtlview_Last Name")).getText();
	System.out.println(expectedcontact);
	if(expectedcontact.equals(actualcontact))
	{
		System.out.println("Pass:Contact Name is correct");
	}
	else
	{
		System.out.println("Fail:Contact name is incorrect");
	}
	Thread.sleep(2000);
	
	
	//to logout
	//mouse hovering on user element
	WebElement user = driver.findElement(By.xpath("//img[contains(@src,'/user.PNG')]"));
	Actions action=new Actions(driver);
	action.moveToElement(user).perform();
	Thread.sleep(2000);
	
	//click on signout
	driver.findElement(By.linkText("Sign Out")).click();
	//driver.quit();
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
