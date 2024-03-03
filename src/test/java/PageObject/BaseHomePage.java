package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseHomePage extends BaseConstructor{

		WebDriver driver;
		public BaseHomePage (WebDriver driver)	
		{
			super(driver);
		}
		
		
		//Locators
		
		@FindBy(xpath="//a[normalize-space()='Register']") WebElement reg;
		@FindBy(xpath="//a[normalize-space()='Log in']") WebElement login;
		
		//Actions
		
		public void Register()
		{
			reg.click();
		}
		public void login()
		{
			login.click();
		}
}
