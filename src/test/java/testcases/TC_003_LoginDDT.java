package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class) // this is we need to pass here
	public void verify_loginDDT(String email,String password,String exp)
	{
		
		
		logger.info("***** Starting of TC_003_LoginDDT ******");
		logger.debug("capturing application debug logs ");  
		
		try
		{
		// HomePage
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Entering valid login and password...");
		lp.setEmail(email);
		lp.setpassword(password);
		
		lp.clickLogin();
		logger.info("click on Login button");
		
		// MyAccount Page
		MyAccountPage Mp = new MyAccountPage(driver);
		
		boolean targetPage = Mp.isMyAccountPageExists();
		
		// Positive tesing
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				Mp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		// Negative testing
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				Mp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("**** Finished the TC_003_LoginDDT ****");
		
		
		}
	
}
