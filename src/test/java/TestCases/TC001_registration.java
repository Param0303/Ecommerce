package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.BaseHomePage;
import PageObject.RegisterPage;
import TestBaseClass.BaseClass1;
public class TC001_registration extends BaseClass1
{
	
	@Test(priority=1,groups={"regrassion","master"})
	public void homepage()
	{
		BaseHomePage hp= new BaseHomePage(driver);
		logger.info("****** Go to homepage and click regidter link *****");
		hp.Register();
	}
	@Test(priority=2,dependsOnMethods= {"homepage"},groups= {"regrassion","master"})
	public void Registration()
	{
		
		RegisterPage rp= new RegisterPage(driver);
		logger.info("Clicked gender");
		rp.gender();
		logger.info("Enterd firstname");
		rp.firstname(randomeString());
		logger.info("Enterd lastname");
		rp.lastname(randomeString());
		logger.info("Enterd email");
		rp.email(randomeString()+"@gmail.com");
		rp.pandcp(randomealphanumeric());
		logger.info("Clicked submit");
		rp.registration();
		rp.massegeConfirmation();
		String msg=rp.massegeConfirmation();
		System.out.println(msg);
		Assert.assertEquals(msg,"Your registration completed");
		rp.btnclick();
		
		
	}
}
