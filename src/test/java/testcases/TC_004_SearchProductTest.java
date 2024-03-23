package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchPage;
import testBases.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {
  
	@Test(groups= {"master"})
	public void verifyproductSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			//hm.enterProductName("iPhone");
			hm.enterProductName("Mac");
			logger.info("Enter the product name");
			
			hm.clickSearch();
			logger.info("click on search button");
			
			SearchPage sp=new SearchPage(driver);
			sp.isProductExist("MacBook");
			
			logger.info("verify the Availablity of Product");
			
			Assert.assertEquals(sp.isProductExist("MacBook"),true);

		} 
		catch (Exception e) 
		{
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}
