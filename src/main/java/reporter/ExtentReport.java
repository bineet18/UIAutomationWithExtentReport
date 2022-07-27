package reporter;

import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;

import propertyInitializer.initializeConfiguration;

public class ExtentReport extends initializeConfiguration
{
	Properties propC;
	static ExtentReports extent;
	
	public ExtentReport() throws IOException 
	{
		this.propC=super.propC;
	}
	
	public static ExtentReports getReportObjects()
	{
		String currentWorkingDir = System.getProperty("user.dir");
		
		extent = new ExtentReports();
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(currentWorkingDir+"\\reports\\index.html");
		JsonFormatter json = new JsonFormatter(currentWorkingDir+"\\reports\\extent.json");
		
		try
		{
			extent.createDomainFromJsonArchive(currentWorkingDir+"\\reports\\extent.json");
		}
		catch(IOException e)
		{e.printStackTrace();}
		
		extent.attachReporter(json,reporter);

		return extent;
	}
}
