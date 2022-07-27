package propertyInitializer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class initializeDriver extends initializeConfiguration
{
	Properties propC;
	RemoteWebDriver driver;
	String browser;
	public initializeDriver() throws IOException
	{
		this.propC = super.propC;
	}
	
	public WebDriver returnDriver() throws MalformedURLException
	{
		browser = propC.getProperty("browser");
		String path = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",path+"/drivers/geckodriver.exe"); 
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", path+"/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(propC.getProperty("driverTimeout")), TimeUnit.SECONDS);
		
		
		return driver;
	}
}
