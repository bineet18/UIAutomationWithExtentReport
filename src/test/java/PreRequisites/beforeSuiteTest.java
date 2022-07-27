package PreRequisites;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeSuite;

import reporter.testListener;

public class beforeSuiteTest 
{
	@BeforeSuite
	public void createSuiteTest() throws IOException
	{
		long time = new Date().getTime();
		Timestamp ts = new Timestamp(time);
		testListener.suite = testListener.extent.createTest("Suite execution - "+ts);
		
		FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"//OutputJSON//BadgeID"));
		FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"//OutputJSON//BadgeReceipent"));
		FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"//OutputJSON//BadgeTags"));
	}
}
