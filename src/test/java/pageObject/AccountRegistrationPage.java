package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public WebDriver driver;
	JavascriptExecutor js;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	
	// WebElements with Identification
	
		@FindBy(xpath="//input[@id='input-firstname']") 
		WebElement txtFirstName;
		
		@FindBy(xpath="//input[@id='input-lastname']")
		WebElement txtLastName;
		
		@FindBy(xpath="//input[@id='input-email']")
		WebElement txtEMail;
		
		@FindBy(xpath="//input[@id='input-password']")
	    WebElement txtpassword;
		
		@FindBy(xpath = "//input[@type='checkbox'][@name='agree']")
		WebElement PrivacyPolicy;
		
		
		@FindBy(xpath="//button[normalize-space()='Continue']")
		WebElement btncontinue;
		
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;
		
		// Action methods
		public void setFirstName(String Fname)
		{
			txtFirstName.sendKeys(Fname);
		}
		
		public void setLastName(String Lname)
		{
			txtLastName.sendKeys(Lname);
		}
		
		public void setEmail(String email)
		{
			txtEMail.clear();
			txtEMail.sendKeys(email);
		}
		
		public void setpassword(String password)
		{
			txtpassword.sendKeys(password);
			
		}
		
		public void setAllPolicy() 
		{
		
			js.executeScript("arguments[0].click();",PrivacyPolicy);
			//PrivacyPolicy.click();
		}
		
		public void ClickButton()
		{
			 
			btncontinue.submit();
			  
		}
		
		// normally we might face some Exception 
		//during the click continue action so for that

		  //we have few more alternate option we should try
		  //2)sol
		  //btncontinue.submit();
		  
		  //3)sol
		  //Actions act = new Actions(driver);
		  //act.moveToElement(btncontinue).click().perform();
		  
		  
		  //4)sol
		  //JavascriptExecutor js = (JavascriptExecutor) driver;
		  // js.executeScript("agruments[0].click();",btncontinue);
		
		  
		  //5)sol
		  // btncontinue.sendkeys(keys.RETURN);
		
		    
		  //6)sol
		  //WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  //mywait.until(ExpectedCondtions.elementToBeClickable(btnContinue)).click();
		
		
		
		public String getConfirmationMsg()
		{
			try
			{
			    return (msgConfirmation.getText());
			    
			}
			catch(Exception e)
			{
				return (e.getMessage());
			}
	
		}
}
