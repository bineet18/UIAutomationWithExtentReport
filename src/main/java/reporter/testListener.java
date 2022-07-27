package reporter;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class testListener implements ITestListener
{
	public static ExtentReports extent = ExtentReport.getReportObjects();
	public static ExtentTest suite;
	public static ExtentTest test;
	public static ExtentTest childTest;
	
	@Override
	public void onTestStart(ITestResult result)
	{
		childTest = test.createNode(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		childTest.pass("The Testcase is PASSED");
		extent.flush();
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		childTest.fail(result.getThrowable());
		extent.flush();
	}
}
