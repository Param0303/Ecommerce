package PageObject;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartAProductPage extends BaseConstructor
{
	WebDriver driver;
	public Properties p;
	public CartAProductPage (WebDriver driver)
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
	@FindBy(xpath= "//input[@name='removefromcart']") WebElement cb  ;
	@FindBy(xpath= "//input[@name='updatecart']") WebElement uc   ;
	
	
	
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
	public void clickbox()
	{
		cb.click();
	}
	public void updatecart()
	{
		uc.click();
	}
}
