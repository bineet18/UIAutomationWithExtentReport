package uiAutomation;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import propertyInitializer.initializeXpath;
import reporter.logToExtentReport;

public class QuestionsPage extends initializeXpath
{
	WebDriver driver;
	Properties propX;

	public QuestionsPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		this.propX = super.propX;
	}
	
	public void clickOnTags()
	{
		driver.findElement(By.xpath(propX.getProperty("tags"))).click();

		new logToExtentReport().logScreenshotsToExtentReport(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), "Click on Tags");
	}
}
