package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

  //Step:1:We should create public class and give the class name as webpage name
   
   public class LoginPage {
	
	//declaration--->We will declare locators as private
	
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//Step:3:Initialization--->We will create public constructors and initialize the element variables
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//LoginPage.class //this---take driver object  and initialize it
		                                       //pagefactory not used Stale element exception
	}

	
	//Step:4:Utilization--->by developing public getters or /and busniness library
	
	//Way:1:By creating PUBLIC GETTERS
	
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Way:1:By creating BUSINESS LIBRARY
	
	
		public void createLoginPage(String userName,String password){
			
		userNameTextField.sendKeys(userName);//use this if its in same class no getter
		passwordTextField.sendKeys(password);
		loginButton.click();
		
		
		//getUserNameTextField().sendKeys("admin");
		//getPasswordTextField().sendKeys("admin");
		//getLoginButton().click();
		
			
		
		
	}
	
	
	
	
	
	

}
