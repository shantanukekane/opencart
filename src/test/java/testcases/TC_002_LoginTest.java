package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBases.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"sanity","master"})
	public void verify_Login_Test()
	{
		
		  // Loading the log4j2 
		
		logger.info("***** Starting of TC_002_Login Test ******");
		logger.debug("capturing application debug logs ");  
		
		try
		{
		// HomePage
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("click on My account link on the Homepage "); 
	
		hp.clickLogin();
		logger.info("click on login link under myaccount");
		
		//LoginPage
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Entering valid login and password...");
		lp.setEmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		
		lp.clickLogin();
		logger.info("click on Login button");
		
		// MyAccount Page
		MyAccountPage Mp = new MyAccountPage(driver);
		
		boolean targetPage = Mp.isMyAccountPageExists();
		
		if(targetPage == true)
		{
			logger.info("login test successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login test failed");
			Assert.fail();
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("**** Finished the Login Test *****");
		
	}	
		
		
		
}
