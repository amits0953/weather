package weatherComparator.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import utiles.Extentreport;


public class BaseLib extends Extentreport  {

	public static WebDriver driver;
	 Extentreport node;
	   @BeforeTest
	    public void set()
	    {
	         test=extentReports.createTest("RamJi");
	    }
	@BeforeMethod
	@Parameters({"browser" , "baserurl"})
	public void precondition(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		 {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			 System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			 driver= new ChromeDriver(options);
			 Reporter.log("chrome is launched", true);
			 test.info("pass");
		
		 }
		 
		 else if(browserName.equalsIgnoreCase("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			 driver= new FirefoxDriver();
			 Reporter.log("fire fox launched", true);
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.navigate().to(url);
		 Reporter.log(url +"url is navigated ", true);
		
	}
	 @AfterMethod
	  public void postCondition()
	  {
		  driver.close();
		  Reporter.log("Browser closed", true);
		  if(driver!=null)	  
		  {
			  driver.quit();
			  Reporter.log("All session are closed ", true);
		  }
	  }
}
