package com.crm.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GroupExecution {

	@Test(priority = 1)
	public void testNGPracticeTest() {
		Reporter.log("TestNGPractice Test", true);
	}

	@Test(priority = 4)
	public void testNGPracticeTest1() {
		Reporter.log("TestNGPractice Test1", true);
	}
	@Test(priority = 3)
	public void testNGPracticeTest2() {
		Reporter.log("TestNGPractice Test2", true);
	}
	@Test(priority = 2)
	public void testNGPracticeTest3() {
		Reporter.log("TestNGPractice Test3", true);
	}
		
	}

	
	
	

