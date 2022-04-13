package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleStaleException {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://localhost:8888/");
		LoginPage loginpage=new LoginPage(driver);
		//loginpage.enterUN_PWD("admin","admin");
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		
		
		

	}

}
