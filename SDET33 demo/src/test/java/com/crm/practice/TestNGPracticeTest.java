package com.crm.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
	@Test
	public void testNGPracticeTest() {
		Reporter.log("Hi", true);//if false we wont get message
		}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Thankyou", true);
	}
	
	
	@Test
	public void testNGPracticeTest1() {
		Reporter.log("Hello", true);
	}
	
	@Test
	public void testNGPracticeTest2() {
		Reporter.log("Fine", true);
	}
	
    
	@BeforeSuite
	public void beforeSuite() {
     Reporter.log("Goodmorning", true);
}
	
	
	
	
	
}
