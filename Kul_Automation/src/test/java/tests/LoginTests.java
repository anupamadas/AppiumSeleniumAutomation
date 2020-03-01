package tests;


import java.lang.reflect.Method;

import org.testng.annotations.Test;

import Listeners.ExtentTestManager;
import pages.HomePage;
import pages.LibraryPage;


public class LoginTests extends BaseTest{

	 
	
	@Test
	public void testEvaluation(Method method) throws Exception
	{
		ExtentTestManager.startTest(method.getName(), "Verify the test");
		HomePage homepage = new HomePage(driver);
		LibraryPage loginpage = new LibraryPage(driver);
		homepage.launchURL();
		loginpage.selectLibrary();
		
	}
	
	
	
	
}
