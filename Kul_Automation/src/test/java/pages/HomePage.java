package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

	String URL = "https://familiar.lsac.org/";
	
	 /*
	  * Initialization of page objects
	  */
   public HomePage (RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
   
 
   /*
	 * Page object repository
	 */
   
   @FindBy(xpath="//*[@class='libraryHeader']/span")
   WebElement loginHeader;

  /*
   * method to launch url in chrome browser with specified driver in testng xml
   */
   
    public void launchURL() throws Exception
    {
    	driver.get(URL);
    	isElementPresent(loginHeader,80);
    }
    
    
 
    
    
}
