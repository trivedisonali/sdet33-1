package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {                  //to verify organization name

	@FindBy(id="dtlview_Organization Name")
	private WebElement Orgverify;
	
	@FindBy(id="dtlview_Industry")
	private WebElement Industrydropdownverify;
	
	@FindBy(id="dtlview_Type")
	private WebElement Typedropdownverify;

	
	
   public OrgInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


//way 1
   
    public WebElement getOrgverify() {
	return Orgverify;
}
   

    public WebElement getIndustrydropdownverify() {
	return Industrydropdownverify;
}


    public WebElement getTypedropdownverify() {
	return Typedropdownverify;
}

//way 2
       public String verifyOrgName() {
	   String text=Orgverify.getText();
	   return text;
       }
	   
	   public String  verifyIndustrydropdown() {
	   String text=Industrydropdownverify.getText();
	   return text;
		
	   }
	   
	   public String verifyTypedropdown() {
	   String text = Typedropdownverify.getText();
	   return text;
		
	   }
	 }
	   
       
	   
	   
	   
	   
	  