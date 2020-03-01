
package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseTest {
	/*
	 * Intializing driver
	 */
	 public RemoteWebDriver driver;
	 
	 
	  public RemoteWebDriver getDriver() {
	        return driver;
	    }
	
	 
	@Parameters("browser")
	 
	 @BeforeClass
	  public void getDrivertype(String browser) {
		  switch (browser) {

	case("chrome"): 
     System. setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\ext\\chromedriver.exe");
          driver = new ChromeDriver();
             break;
             
    case("safari"):
			driver= new SafariDriver();
		  break;
		  
     case ("Android") : 
            	 try {
            	
           DesiredCapabilities caps=new DesiredCapabilities();
           caps.setCapability("deviceName", "SM-A507FN"); 
           caps.setCapability("udid","RZ8MA1015BR"); 
           caps.setCapability("platformName", "Android");
           caps.setCapability("platformVersion", "9");
           caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
         URL url=new URL("http://127.0.0.1:4723/wd/hub"); 
         driver=new AppiumDriver<WebElement>(url,caps); 
         Thread.sleep(5000);
         System.out.println("Run Appilation");
         break;
         }
         catch(Exception exp) { 
        	 exp.getCause();
             exp.getMessage(); }
      
		  }       
		  
	    }
   

	  
	    @AfterClass
	    public void teardown () {
	        driver.quit();
	    }

		public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSkipped(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailure(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestStart(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onFinish(ITestContext iTestContext) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext iTestContext) {
			// TODO Auto-generated method stub
			
		}
	}

