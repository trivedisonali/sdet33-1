package com.crm.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class BatchExecution {
	
	
	@Test
	public void testNGPracticeTest() {
		Reporter.log("TestNGPractice Test", true);
	}

	@Test
	public void testNGPracticeTest1() {
		Reporter.log("TestNGPractice Test1", true);
	}
	@Test
	public void testNGPracticeTest2() {
		Reporter.log("TestNGPractice Test2", true);
	}
	@Test
	public void testNGPracticeTest3() {
		Reporter.log("TestNGPractice Test3", true);
	}
		
	}
