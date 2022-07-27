 package APITest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import apiAutomation.badgeReceipent;
import reporter.testListener;

public class badgeReceipent_positive
{
	@BeforeClass
	public void initializeProperties()
	{
		testListener.test = testListener.suite.createNode(this.getClass().getSimpleName());
	}
	
	@Test
	public void badgeReceipent() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("site", "stackoverflow");
		new badgeReceipent(queryParam,200).getBadgeReceipent(new Object(){}.getClass().getEnclosingMethod().getName());
	}
}
