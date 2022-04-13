package com.crm.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assertpractice {
	
	@Test

	public void practice1() {
		
		String s="SDET33";
		Assert.assertTrue(s.equals("sdet"));
		Reporter.log("will it get printed?");//expected true but got false,error
		
	}
	@Test
	public void practice2() {
		String s="SDET33";
		Assert.assertTrue(s.equals("SDET33"));
		Reporter.log("will it get printed?");//expected true but got true,pass
		
	}
	
	@Test
	
	public void practice3() {
		String s="SDET33";
		Assert.assertFalse(s.equals("sdet"));
		Reporter.log("will it get printed?");//expected false and got false,pass
	}
	
	
	@Test
	public void practice4() {
		String s="SDET33";
		Assert.assertTrue(true, "Hello");
		Reporter.log("will it get printed?");//expected false and got false,pass
		
	}
	
	
	
}
