package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Purchase_page extends BaseConstructor
{
	WebDriver driver;
	public Purchase_page(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	
	@FindBy(xpath= "//input[@name='q']") WebElement scarch  ;
	@FindBy(xpath= "//input[@type='submit']") WebElement  btnscarch ;
	@FindBy(xpath= "//input[@value='Add to cart']") WebElement addto;
	@FindBy(xpath= "//input[@id='product_attribute_75_5_31_96']") WebElement processor   ;
	@FindBy(xpath= "//input[@id='product_attribute_75_6_32_99']") WebElement ram  ;
	@FindBy(xpath= "//input[@id='product_attribute_75_3_33_103']") WebElement hdd   ;
	@FindBy(xpath= "//input[@id='product_attribute_75_8_35_108']") WebElement  soft ;
	@FindBy(xpath= "//input[@id='addtocart_75_EnteredQuantity']") WebElement qty  ;
	@FindBy(xpath= "//input[@id='add-to-cart-button-75']") WebElement btncart  ;
	@FindBy(xpath= "//p[text()='The product has been added to your ']") WebElement check  ;
	@FindBy(xpath= "//a[@class='ico-cart']/span") WebElement  scart ;
	@FindBy(xpath="//select[@name=\'CountryId\']")  WebElement coun;
	@FindBy(xpath="//select[@name='StateProvinceId']")  WebElement sta; 
	@FindBy(xpath="//input[@name='ZipPostalCode']")  WebElement zip;
	@FindBy(xpath="//input[@name='termsofservice']")  WebElement terms;
	@FindBy(xpath="//button[@name='checkout']")  WebElement checkout;
	@FindBy(xpath="//select[@name='billing_address_id']") WebElement bil;
	@FindBy(xpath="//input[@name='BillingNewAddress.Company']")  WebElement company;
	@FindBy(xpath="//select[@name='BillingNewAddress.CountryId']")  WebElement country;
	@FindBy(xpath="//input[@name='BillingNewAddress.City']")  WebElement city;
	@FindBy(xpath="//input[@name='BillingNewAddress.Address1']")  WebElement address;
	@FindBy(xpath="//input[@name='BillingNewAddress.ZipPostalCode']")  WebElement zip2;
	@FindBy(xpath="//input[@name='BillingNewAddress.PhoneNumber']")  WebElement phone;
	@FindBy(xpath="//input[@onClick='Billing.save()']")  WebElement con1;
	@FindBy(xpath="//input[@onClick='Shipping.save()']")  WebElement con2; 
	@FindBy(xpath="//input[@onClick='ShippingMethod.save()']")  WebElement con3;
	@FindBy(xpath="//input[@onClick='PaymentMethod.save()']")  WebElement con4;
	@FindBy(xpath="//input[@onClick='PaymentInfo.save()']")  WebElement con5;
	@FindBy(xpath="//input[@onClick='ConfirmOrder.save()']")  WebElement con6;
	@FindBy(xpath="//strong[text()='Your order has been successfully processed!']")  WebElement check1 ;

	public void Search(String product)
	{
		scarch.sendKeys(product);
	}
	public void Searchbutton()
	{
		btnscarch.click();
	}
	public void addtocart() 
	{
		addto.click();
	}
	public void clickprocessor()
	{
		processor.click();
	}
	public void clickram()
	{
		ram.click();
	}
	public void clickhdd()
	{
		hdd.click();
	}
	public void clicksoftware()
	{
		soft.click();
	}
	public void chooseqty(String quantity)
	{
		qty.clear();
		qty.sendKeys(quantity);
	}
	public void clickcart() throws InterruptedException
	{
		btncart.click();
		Thread.sleep(4000);
	}
	public boolean verifytext()
	{
		boolean t =check.isDisplayed();
		return t;
		
	}
	
	public void clickscart()
	{
		scart.click();
	}
	
	public void SetCountry(String a)
	{
		Select sel= new Select(coun);
		sel.selectByVisibleText(a); 
	}
	public void SetState(String b)
	{
		Select sel= new Select(sta);
		sel.selectByVisibleText(b); 
	}
	public void SetZip(String c)
	{
		zip.sendKeys(c);
	}
	public void AcceptTerms()
	{
		terms.click();
	}
	public void ClickCheckout()
	{
		checkout.click();
	}
	public void Billingaddress(String z)
	{
		Select sel= new Select (bil);
		sel.selectByVisibleText(z);
	}
	public void SetCompany (String d)
	{
		company.sendKeys(d);
	}
	public void SetCountry1(String e)
	{
		country.sendKeys(e);
	}
	public void SetCity(String f)
	{
		city.sendKeys(f);
	}
	public void SetAddress(String g)
	{
		address.sendKeys(g);
	}
	public void SetZip1(String h)
	{
		zip2.sendKeys(h);
	}
	public void SetPhone (String i)
	{
		phone.sendKeys(i);
	}
	
	public void Continue1()
	{
		con1.click();
	}
	public void Countinue2()
	{
		con2.click();
	}
	public void Countinue3()
	{
		con3.click();
	}
	public void Continue4()
	{
		con4.click();
	}
	public void Countinue5 ()
	{
		con5.click();
	}
	public void Countinue6 ()
	{
		con6.click();
	}
	public String OrderCheck()
	{
		String oc= check1.getText();
		return oc;
		
	}
	
}
