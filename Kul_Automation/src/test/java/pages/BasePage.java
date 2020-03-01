package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class BasePage {
    public RemoteWebDriver driver;
    public WebDriverWait wait;
 
    //Constructor
    public BasePage (RemoteWebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }
 
    //Verify existence of element
    public boolean isElementPresent(WebElement elementName, int timeout){
    	try{
    	        WebDriverWait wait = new WebDriverWait(driver, timeout);
    	        wait.until(ExpectedConditions.visibilityOf(elementName));
    	        return true;
    	}catch(Exception e){
    	    return false;
    	}
}

    //Wait Wrapper Method
    public void waitVisibility(WebElement errorMessageUsernameBy) {
    	isElementPresent(errorMessageUsernameBy, 60);
    }
 
 
   
 
    //Read Text
    public String readText (WebElement elementBy) {
        waitVisibility(elementBy);
        return elementBy.getText();
    }
 
    //Assert
    public void assertEquals (WebElement errorMessageUsernameBy, String expectedText) {
        waitVisibility(errorMessageUsernameBy);
        Assert.assertEquals(readText(errorMessageUsernameBy), expectedText);
 
    }
    
    //Verify invisibility of element
    public boolean isElementNotPresent(WebElement elementName, int timeout){
    	try{
    	        WebDriverWait wait = new WebDriverWait(driver, timeout);
    	        wait.until(ExpectedConditions.visibilityOf(elementName));
    	        return false;
    	}catch(NoSuchElementException e){
    	    return true;
    	}
}
}
