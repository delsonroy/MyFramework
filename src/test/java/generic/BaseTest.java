package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.ITest;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;

	@Parameters({ "grid", "gridURL", "browser", "appUrl", "ITO", "ETO" })
	@BeforeMethod
	public void preCondition(

			@Optional("no") String grid, @Optional("http://192.168.111.1:4444") String gridURL,
			@Optional("chrome") String browser, @Optional("appUrl") String appUrl, @Optional("7") String ITO,
			@Optional("6") String ETO) throws MalformedURLException

	{
		Reporter.log("Browser is " + browser, true);

		if (grid.equalsIgnoreCase("yes"))
		{
			URL url = new URL(gridURL);
			    if (browser.equalsIgnoreCase("chrome"))
			    {
				
				ChromeOptions options = new ChromeOptions();
				 driver = new RemoteWebDriver(url, options);
			} 
			else
			{
			 
			 FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(url, options);
			}
		}
		 else {

			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
		}

		Reporter.log("ITO timeout", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ITO)));
		Reporter.log("Get URL", true);
		driver.get(appUrl);
		Reporter.log("Maximize the browser", true);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.valueOf(ETO)));
       
	}

	@AfterMethod()
	public void postCondition(ITestResult result) {
		
		String testfailed = result.getName();
		int status = result.getStatus();
		
		if(status==2)
		{
			TakesScreenshot t=(TakesScreenshot)driver;
			
					
			
		}
		
		Reporter.log("After method", true);
		driver.quit();
	}
}
