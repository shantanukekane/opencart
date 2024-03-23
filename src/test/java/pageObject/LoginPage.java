package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// locators 
	
    @FindBy(xpath="//input[@id='input-email']") 
    WebElement txtEmail;
    
    @FindBy(xpath="//input[@id='input-password']") 
    WebElement txtpassword;
    
    @FindBy(xpath="//button[normalize-space()='Login']") 
    WebElement btnlogin;
    
	
	// Action methods 
    
    public void setEmail(String email)
    {
    	txtEmail.sendKeys(email);
    }
    
    public void setpassword(String pwd)
    {
    	txtpassword.sendKeys(pwd);
    }
    
    public void clickLogin()
    {
    	btnlogin.click();
    }
	
    
	
}
