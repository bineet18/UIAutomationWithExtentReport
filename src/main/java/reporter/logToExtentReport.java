package reporter;

import java.io.File;
import java.io.PrintStream;
import java.io.StringWriter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class logToExtentReport 
{
	public void logAPIlogsToExtentReport(StringWriter requestWriter, PrintStream requestCapture, StringWriter responseWriter,
			PrintStream responseCapture, String nodeName, int statusCode)
	{
		requestCapture.flush();
		responseCapture.flush();
		
		ExtentTest childTest = testListener.childTest.createNode(nodeName);
		childTest.createNode(requestWriter.toString());
		
		int actualStatusCode = Integer.parseInt(responseWriter.toString().substring(9,12));
		
		if(actualStatusCode == statusCode)
		{
			childTest.createNode(responseWriter.toString()).pass("PASSED with HTTP code:"+actualStatusCode);
		}
		else
		{
			childTest.createNode(responseWriter.toString()).fail("FAILED with HTTP code:"+actualStatusCode+
					"\nExpected HTTP code was: "+statusCode);
			org.testng.Assert.fail();
		}
	}
	
	public void logScreenshotsToExtentReport(File srcFile, String nodeName)
	{
		ExtentTest childTest = testListener.childTest.createNode(nodeName);

		childTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(srcFile.getAbsolutePath()).build());
		
	}
}
