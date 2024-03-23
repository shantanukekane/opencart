package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage  extends BasePage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Locators
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")  // Myaccount Page Heading 
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class = 'list-group mb-3']/a[13][text() = 'Logout']")
	WebElement lnklogout;
	
	
	// action methods
	
	public boolean isMyAccountPageExists()
	{
		
	  try
	  {
		return(msgHeading.isDisplayed());
	      
	  }
	  catch(Exception e)
	  {
		 return(false);
	  }
	
	
	}
	
	
	public void clickLogout() 
	{
		lnklogout.sendKeys(Keys.RETURN);
	}
	  
	  
	
	
}
