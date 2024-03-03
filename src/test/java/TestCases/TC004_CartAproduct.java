package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseHomePage;
import PageObject.CartAProductPage;
import PageObject.LoginPage;
import TestBaseClass.BaseClass1;

public class TC004_CartAproduct extends BaseClass1 {
	
	@Test(priority=1, groups= {"sanity","master"})
		public void login() throws InterruptedException
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
		}
		@Test(priority=2, dependsOnMethods= {"login"}, groups= {"sanity","master"})
		public void Scarch() throws InterruptedException
		{
		CartAProductPage capp= new CartAProductPage(driver);
		capp.Search(p.getProperty("product"));
		capp.Searchbutton();
		capp.addtocart();
		capp.clickprocessor();
		capp.clickram();
		capp.clickhdd();
		capp.clicksoftware();
		capp.chooseqty(p.getProperty("quantity"));
		capp.clickcart();
		 boolean text = capp.verifytext();
		 Assert.assertEquals(true,text);
		 capp.clickscart();
		 capp.clickbox();
		 capp.updatecart();
		 
	}
}
