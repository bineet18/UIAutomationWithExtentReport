package UITest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import propertyInitializer.initializeConfiguration;
import propertyInitializer.initializeDriver;
import reporter.testListener;
import uiAutomation.HomePage;
import uiAutomation.QuestionsPage;
import uiAutomation.TagsPage;

public class getTagFromStackoverflow 
{
	static Properties propC;
	static WebDriver driver;
	
	
	  @BeforeClass 
	  public void beforeClass() throws IOException 
	  {
		  initializeConfiguration c = new initializeConfiguration(); // Initialize the Configuration File 
		  propC = c.returnConfiguration();
		  
		  testListener.test = testListener.suite.createNode(this.getClass().getSimpleName());
		  
		  initializeDriver i= new initializeDriver(); // Initialize the WebDriver
		  driver = i.returnDriver(); driver.manage().window().maximize(); // Maximize  the Window
		  
		  driver.get(propC.getProperty("URL")); 
	  }

    @Test(enabled=true)
    public void getTagWithMaximumQuestionsTest() throws IOException, InterruptedException
    {
    	new HomePage(driver).clickOnBrowse();
    	new QuestionsPage(driver).clickOnTags();
    	new TagsPage(driver).clickOnName();
    	ArrayList<String> result = new TagsPage(driver).returnTagNameWithHighestQuestions();
    	
    	System.out.println("Tag with name: "+result.get(0)+" has highest number of questions with: "+result.get(1)+" questions");
    }
    
    @AfterClass
    public void afterClass()
    {
		/*
		 * driver.close(); driver.quit();
		 */
    }
}
