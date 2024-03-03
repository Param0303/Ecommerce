package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseConstructor 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='Email']") WebElement mail ;
	@FindBy(id="Password") WebElement pass;
	@FindBy(xpath="//input[@id='RememberMe']") WebElement remember;
	@FindBy(xpath="//input[@type='submit'][@value='Log in']") WebElement btnlogin;
	@FindBy(xpath="//a[normalize-space()='paramartharoy28@gmail.com']") WebElement check;
	@FindBy(xpath="//a[normalize-space()='Log out']") WebElement lo;
	
	
	public void setmail(String email)
	{
		mail.sendKeys(email);
	}
	public void setpassword(String password)
	{
		pass.sendKeys(password);
	}
	public void setrememberme()
	{
		remember.click();
	}
	public void loginbtn()
	{
		btnlogin.click();
	}
	public String registercheck()
	{
		try
		{
			String r =check.getText();
			return(r);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	public void logout()
	{
		lo.click();
	}
	
}
