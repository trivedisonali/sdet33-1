package com.crm.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.io.Files;

/**
 * This class is a collection of all the webdriver actions
 * @author HP
 *
 */

public class DriverUtility {

	/**
	 * Method for implicit wait for specified time
	 * @param driver
	 * @param timeoutLong
	 * 
	 * 
	 */


	public static void waitforPageLoad(WebDriver driver,long timeoutLong) {
		driver.manage().timeouts().implicitlyWait(timeoutLong, TimeUnit.SECONDS);
	
	}
	
	/**
	 * This method is used to wait until element visible
	 * @param driver
	 * @param timeout
	 * @param element
	 */
	public static void waituntilElementVisible(WebDriver driver,Long timeout,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until element visible with specific polling time
	 * @param driver
	 * @param timeout
	 * @param element
	 */
	
	public static void waituntilFluentWaitElementVisible(WebDriver driver,Long timeout,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.visibilityOf(element));
	wait.pollingEvery(Duration.ofSeconds(timeout));
}
	
	/**
	 * This method will wait until element is clickable with customize time and polling
	 * @param element
	 * @param pollingTime
	 * @param timeout
	 * @throws Throwable 
	 */
	public static void customwaitTillElemenmtClickable(WebElement element,int pollingTime,int timeout) throws Throwable {
	
	int count=0;//time=20,it will run 20s
	while(count<=timeout)
	try {
		
		element.click();
		break;
		}
	 catch (NoSuchElementException e) {
		 Thread.sleep(pollingTime);
		 count++;
		
	}
	}
	/**
	 * This method will maximize the browser window
	 * @param driver
	 */
	
	public static void maximizeBrowser(WebDriver driver){ /////GIVEN THIS METHOD INSIDE OTHER METHOD
		driver.manage().window().maximize();
	}
	
	/**
	 *This method is used to open the application 
	 * @param driver
	 * @param url
	 */
	public static void launchApplication(WebDriver driver,String url,long timeout)
	{
		driver.get(url); 
		waitforPageLoad(driver,timeout);
		 
		//here itself we can call maximize method
			
	}
	
	
	public static void launchApllicationwithMaximize(WebDriver driver,String url,long timeout)
	{
		driver.get(url);
		maximizeBrowser(driver);
		waitforPageLoad(driver,timeout);
		
		
		
	}
	
/**
 * @return 
 * 
 */
	public static void switchToWindow() {
	
	}
	
	/**
	 * This method is used to move the cursor to element
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to right click on element
	 * @param driver
	 * @param element
	 */
	
	public static void rightClickonElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * This method is used to double click on element
	 * @param driver
	 * @param element
	 */
	public static void doubleClickonElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to select dropdownoption by index
	 * @param element
	 * @param index
	 */
	public static void select(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
		
	}
	
	/**
	 * This method is used to select dropdownoption by element
	 * @param element
	 * @param value
	 */
	public static void select(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
		
	}
	
	/**
	 * This method is used to select dropdownoption by text
	 * @param text
	 * @param element
	 */
	public static void select(String text,WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
	}
	/**
	 * This method is used to quit the browser instance
	 * @param driver
	 */
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
		
	}
	
	/**
	 * This method is used to switch the frame by index
	 * @param driver
	 * @param index
	 */
	public static void frames(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This method is used to switch the frame by nameorid
	 * @param driver
	 * @param nameOrId
	 */
	public static void frames(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
		
	}
	
	/**
	 * To print statements
	 * @param text
	 */
	public static void println(String text,boolean value) {
		Reporter.log(text, value);
	}
	
	/**
	 * This method is used to switch the frame by element
	 * @param driver
	 * @param element
	 */
	public static void frames(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
		
	}
	/**
	 * This method is used to take the screenshot if script got failed 
	 * @param driver
	 * @param Filename
	 * @throws IOException 
	 */
	public static void takeScreenShotofFailedScript(WebDriver driver,String Filename) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./errorshots/"+Filename+"_"+JavaUtility.getCurrentDateAndTime()+".png");
		FileUtils.copyFile(src, dst);
		//Files.copy(src, dst); // any method u can use
		
		}
	/**
	 * This method is used to take the screenshot if script got failed  and also it will return the absolute path of screenshot where its stored
	 * @param driver
	 * @param Filename
	 * @return 
	 * @throws Throwable 
	 */
	
	public static String getScreenshotandgetPath(WebDriver driver,String Filename) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./errorshots/"+Filename+"_"+JavaUtility.getCurrentDateAndTime()+".png");
		FileUtils.copyFile(src, dst);
		//Files.copy(src, dst); // any method u can use
		String absolutePath = dst.getAbsolutePath();
		return absolutePath;
		
		}
	/**
	 * This method is used to open the application through javascript
	 * @param driver
	 * @param url
	 */
	public static void openApplicationThroughJS(WebDriver driver,String url)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.location='"+url+"'");
	}
	
	/**
	 * This method is used to enter data into particular textfield
	 * @param driver
	 * @param element
	 * @param input
	 */
	public static void sendkeysThroughJs(WebDriver driver,WebElement element,String input)	
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+input+"'",element);
		
	}
	
	/**
	 * This method is used to click on element 
	 * @param driver
	 * @param element
	 */
	public static void clickthroughJavascriptexecutor(WebDriver driver,WebElement element){
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",element);
		
	}
	/**
	 * This method is scroll the webpage till webelement is present
	 * @param driver
	 * @param element
	 */
	public static void scrollTillElementThroughJS(WebDriver driver,WebElement element) {
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView();",element);
	}
	
	/**
	 * This method is used to send data into particular textfield
	 * @param driver
	 * @param uporDown
	 */
	public static void scrollDownToPageThroughJs(WebDriver driver,String uporDown) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollTo(0,"+uporDown+"document.body.scrollHeight)");
	
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	
	public static String getTextofAlertPopup(WebDriver driver) {
		String popuptext = driver.switchTo().alert().getText();
		return popuptext;
		
	}
	/**
	 * 
	 * @param driver
	 */
	
	public static void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
		
		}
	/**
	 * 
	 * @param driver
	 */
	
	public static void dismissAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
		
	}
	
	
	
	
	
}
