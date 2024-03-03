package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseHomePage;
import PageObject.CartAProductPage;
import PageObject.LoginPage;
import PageObject.Purchase_page;
import TestBaseClass.BaseClass1;

public class TC005_purchase extends BaseClass1
{
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
	public void Cart() throws InterruptedException
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
}
	
	@Test(priority=3 , dependsOnMethods= {"login","Cart"} , groups= {"sanity","master"})
	public void purchase()
	{
		Purchase_page pp= new Purchase_page(driver);
		pp.SetCountry(p.getProperty("Country"));
		pp.SetState(p.getProperty("State"));
		pp.SetZip(p.getProperty("code"));
		pp.AcceptTerms();
		pp.ClickCheckout();
		pp.Billingaddress(p.getProperty("Billing"));
		pp.SetCompany(p.getProperty("Company"));
		pp.SetCountry1(p.getProperty("Country"));
		pp.SetCity(p.getProperty("City"));
		pp.SetAddress(p.getProperty("Address"));
		pp.SetZip1(p.getProperty("code"));
		pp.SetPhone(p.getProperty("Phone"));
		pp.Continue1();
		pp.Countinue2();
		pp.Countinue3();
		pp.Continue4();
		pp.Countinue5();
		pp.Countinue6();
		String mesg= pp.OrderCheck();
		Assert.assertEquals(pp.OrderCheck(),mesg );
		System.out.println(mesg);
		
	}
}

