package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.genericutility.DriverUtility;

//Step:1:We should create public class and give the class name as webpage name

public class CreateNewOrganizationPage {

	//Step:2:declaration--->We will declare locators as private
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement AssignTo;
	
	@FindBy(name="industry")
	private WebElement Industrydropdown;
	
	@FindBy(name="accounttype")
	private WebElement Typedropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Save;
	
	
	//Step:3:Initialization--->We will create public constructors and initialize the element variables
	
	public CreateNewOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}


	//Step:4:Utilization--->by developing public getters or /and busniness library
	//way:1
	
	public WebElement getOrganizationName() {
		return OrganizationName;
	}


	public WebElement getAssignTo() {
		return AssignTo;
	}
	
	public WebElement getIndustrydropdown() {
		return Industrydropdown;
	}


	public WebElement getTypedropdown() {
		return Typedropdown;
	}

	
	public WebElement getSave() {
		return Save;
	}
	
	//way:2
	
	

	public void createNewOrgPageWithOrgName(String OrgName) {
		OrganizationName.sendKeys(OrgName);
		Save.click();
	}
	
	public void  createNewOrgPagewithOrgNameAssignTo (String OrgName) {
		
		OrganizationName.sendKeys(OrgName);
		AssignTo.click();
		Save.click();
		}
	
	public void cretaeNewOrgpagewithDropDownIndustry(String OrgName,String visibleText) {
		
		OrganizationName.sendKeys(OrgName);
		
		WebElement Industrydropdown=getIndustrydropdown();
		DriverUtility.select(visibleText, Industrydropdown);
		
		//got Industrydropdown from get method and stored in webelemnt to call in select
		//when we call Driverutility
	    //Select select=new Select(Industrydropdown); 
		//select.selectByVisibleText(visibleText);
		//visible text we have to take from excel stored and put it in main script
		
		WebElement Typedropdown=getTypedropdown();
		DriverUtility.select(visibleText, Typedropdown);
		
		
		}
	
       public void cretaeNewOrgpagewithDropDownType(String visibleText) {
		
		WebElement Typedropdown=getTypedropdown();
		DriverUtility.select(visibleText, Typedropdown);
		
		Save.click();
		
	}
	
}	
	
