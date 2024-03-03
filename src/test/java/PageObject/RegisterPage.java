package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BaseConstructor 
{
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//label[normalize-space()='Male']") WebElement male;
	@FindBy(id="FirstName") WebElement fname;
	@FindBy(id="LastName") WebElement lname;
	@FindBy(id="Email") WebElement  mail;
	@FindBy(id="Password") WebElement pass;
	@FindBy(id="ConfirmPassword") WebElement conpass;
	@FindBy(id="register-button") WebElement submit;
	@FindBy(xpath="//div[@class='result'][normalize-space()='Your registration completed']") WebElement Conmesg;
	@FindBy(xpath="//div[@class='buttons']//child::input[@value='Continue']") WebElement continuue;
	//actions  
	
	public void gender()
	{
		male.click();
	}
	public void firstname(String fn)
	{
		fname.sendKeys(fn);
	}
	public void lastname(String ln)
	{
		lname.sendKeys(ln);
	}
	public void email(String e)
	{
		mail.sendKeys(e);
	}
	public void pandcp(String p)
	{
		pass.sendKeys(p);
		conpass.sendKeys(p);
	}
	public void registration()
	{
		submit.click();
	}
	
	public String massegeConfirmation()
	{
		try
		{
			return (Conmesg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	public void btnclick()
	{
		continuue.click();
	}
	
}
