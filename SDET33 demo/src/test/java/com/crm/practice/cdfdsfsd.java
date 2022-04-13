package com.crm.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cdfdsfsd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
	   
	jse.executeAsyncScript("window.location.href=http://localhost:8888/");
	

	}

}
