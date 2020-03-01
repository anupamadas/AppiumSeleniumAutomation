package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LibraryPage extends BasePage{
	
 /*
  * Initialization of page objects
  */
	public LibraryPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
	
	/*
	 * Page object repository
	 */
    
    @FindBy(xpath="//a[text()='The Official LSAT PrepTest 71']")
    WebElement officicalLSATTest71;
    @FindBy(xpath="//h1[@class='moduleHeader']")
    WebElement LSATHeader71;
    @FindBy(xpath="//button[@class='ToolbarButton']")
    WebElement section11;
    @FindBy(xpath="//*[text()='Questions']")
    WebElement Questions;
        
    //Method to select a specific library and navigate to section
    public void selectLibrary() throws Exception
    {
    	isElementPresent(officicalLSATTest71,30);
    	officicalLSATTest71.click();
    	isElementPresent(LSATHeader71,60);
    	Assert.assertEquals(LSATHeader71.getText(), "The Official LSAT PrepTest 71");
    	section11.click();
    	isElementPresent(Questions,60);
    	Assert.assertEquals(Questions.getText(), "Questions");
    	
    	
    }
    
 
    
}
