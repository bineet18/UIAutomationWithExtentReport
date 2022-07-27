package uiAutomation;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import propertyInitializer.initializeXpath;
import reporter.logToExtentReport;

public class HomePage extends initializeXpath
{
	WebDriver driver;
	Properties propX;
	
	public HomePage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		this.propX = super.propX;
	}

	public void clickOnBrowse() throws InterruptedException
	{
		driver.findElement(By.cssSelector(propX.getProperty("acceptCookies"))).click();
		
		WebElement element = driver.findElement(By.xpath(propX.getProperty("browseQuestions")));

		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * 
		 * jse.executeScript("arguments[0].scrollIntoView()", element);
		 * jse.executeScript("arguments[0].click()", element);
		 */
		
		element.click();
		
		new logToExtentReport().logScreenshotsToExtentReport(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), "Click on Browse");
	}
}
