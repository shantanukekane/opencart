package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBases.BaseClass;

public class TC__001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"regression","master"})
	public void verify_account_registration() 
	{
		
		logger.info("**** Starting of TC_001_AccountRegistrationTest *****");

		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("click on Myaccount");
		hp.clickRegister();
		logger.info("click on registration");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Entering customer Information");
		regpage.setFirstName(randomeString().toUpperCase());
		//logger.info("Enter the First Name");
		regpage.setLastName(randomeString().toUpperCase());
		//logger.info("Enter the Last Name");
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setpassword(randomAlphaNumeric());
		
		regpage.setAllPolicy();
	
		regpage.ClickButton();
		logger.info("Click on continue Button");
		
		
	    String confirmsg = regpage.getConfirmationMsg();

	    logger.info("Validation the confirmation Message");
		if(confirmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			Assert.fail();
		}
			
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}
		
		logger.info("**** Ending of TC_001_AccountRegistrationTest *****");

		
	}
}
	

