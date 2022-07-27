package uiAutomation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import propertyInitializer.initializeXpath;
import reporter.logToExtentReport;

public class TagsPage extends initializeXpath
{
	WebDriver driver;
	Properties propX;

	public TagsPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		this.propX = super.propX;
	}
	
	public void clickOnName()
	{
		driver.findElement(By.xpath(propX.getProperty("nameTab"))).click();
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		new logToExtentReport().logScreenshotsToExtentReport(SrcFile, "Click on Name");
	}
	
	public ArrayList<String> returnTagNameWithHighestQuestions()
	{
		ArrayList<Integer> questions = new ArrayList<Integer>();
		List<WebElement> elements = driver.findElements(By.xpath(propX.getProperty("questions")));
		ArrayList<String> result = new ArrayList<String>();
		
		
		for(int i=0; i<elements.size(); i++)
		{
			questions.add(Integer.parseInt(elements.get(i).getText().split(" ")[0]));
		}
		
		int maxQuestion = Collections.max(questions);
		int indexOfMaxQuestion = questions.indexOf(maxQuestion);
		
		WebElement element = driver.findElements(By.xpath(propX.getProperty("tagOfQuestion"))).get(indexOfMaxQuestion);
		String tag = element.getText();

		result.add(tag);
		result.add(String.valueOf(maxQuestion));
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);

		
		new logToExtentReport().logScreenshotsToExtentReport(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)
				, "Tag Name: "+result.get(0)+" has Highest number of Questions with: "+result.get(1)+" questions");
		
		return result;	
	}
}
