package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseHomePage;
import PageObject.LoginPage;
import TestBaseClass.BaseClass1;

public class TC002_Login extends BaseClass1 

{
	@Test(groups= {"regrassion","sanity"})
	public void logintest() throws IOException, InterruptedException 
	{
		BaseHomePage bhp= new BaseHomePage(driver);
		logger.info("clicked login button");
		Thread.sleep(2000);
		bhp.login();
		
		LoginPage lp=new LoginPage(driver);
		lp.setmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.setrememberme();
		lp.loginbtn();
		lp.registercheck();
		System.out.println(lp.registercheck());
		Assert.assertEquals(lp.registercheck(), "paramartharoy28@gmail.com");
		Thread.sleep(2000);
		lp.logout();
		
		}
}
