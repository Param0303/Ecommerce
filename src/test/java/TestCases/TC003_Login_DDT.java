package TestCases;
import org.testng.annotations.Test;
import PageObject.BaseHomePage;
import PageObject.LoginPage;
import TestBaseClass.BaseClass1;
import UtilityPackage.DataProviders;

public class TC003_Login_DDT extends BaseClass1
{
	
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class)
	public void verify_login(String email,String password,String exp) throws InterruptedException
	{	
		
		BaseHomePage bhp= new BaseHomePage(driver);
		logger.info("clicked login button");
		bhp.login();
		
		LoginPage lp=new LoginPage(driver);
		lp.setmail(email);
		lp.setpassword(password);
		lp.setrememberme();
		lp.loginbtn();
	    lp.registercheck();
		lp.logout();
}
}
