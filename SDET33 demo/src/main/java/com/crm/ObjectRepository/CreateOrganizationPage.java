package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	
		
		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement CreateOrganizationimg;
		
		public CreateOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public WebElement getCreateOrganizationimg() {
			return CreateOrganizationimg;
		}
		

		public void createOrganization() {
		CreateOrganizationimg.click();
		}

	}


