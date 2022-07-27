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

public class badgeReceipent_negative
{
	@BeforeClass
	public void initializeProperties()
	{
		testListener.test = testListener.suite.createNode(this.getClass().getSimpleName());
	}
	
	
	@Test
	public void badgeReceipentWithInvalidSite() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("site", "stackoverflow342342");
		new badgeReceipent(queryParam,400).getBadgeReceipent();
	}

	@Test
	public void badgeIDWithSiteValueAsInteger() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("site", 123);
		new badgeReceipent(queryParam,400).getBadgeReceipent();
	}
	
}
