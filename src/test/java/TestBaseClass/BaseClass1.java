package TestBaseClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1
{
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups={"sanity","regrassion","master"})
	@Parameters({"os","br"})
	public void setup(String os, String br) throws InterruptedException, IOException 
	{ 
		
		FileReader pfile = new FileReader(".\\src\\test\\resources\\Config_properties");
		p = new Properties();
		p.load(pfile);
		
		
		logger=LogManager.getLogger(this.getClass());
		//remote
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("Operating System is not available in your system");
			}
			
			
			if(br.equalsIgnoreCase("chrome"))
			{
				cap.setBrowserName("chrome");
			}
			else if (br.equalsIgnoreCase("firefox"))
			{
				cap.setBrowserName("firefox");
			}
			
			else if (br.equalsIgnoreCase("edge"))
			{
				cap.setBrowserName("edge");
			}
			 driver = new RemoteWebDriver(new URL("http://192.168.106.74:4444/"),  cap);
		}
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		
		{
		//local
		if (br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if (br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("This Browser is not installed in your system ");
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	
	
	 
	
	@AfterClass(groups= {"sanity","regrassion","master"})
	public void close()
	{
		driver.quit();
	}
	
	//Random data 
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeNumber()
	{
		String generatedNum=RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}
	public String randomealphanumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatedNum=RandomStringUtils.randomNumeric(10);
		return (generatedString+"@"+generatedNum);
	}
	
	    public String captureScreen (String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	    }
	
	
}
