package APITest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import apiAutomation.badgeID;
import reporter.testListener;

public class badgeID_negative
{
	@BeforeClass
	public void initializeProperties()
	{
		testListener.test = testListener.suite.createNode(this.getClass().getSimpleName());
	}
	
	
	@Test
	public void badgeIDWithNegativeID() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "rank");
		queryParam.put("site", "stackoverflow");
		new badgeID(-6505, queryParam,200).getBadgeID();
	}

	@Test
	public void badgeIDWithIDAsZero() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "rank");
		queryParam.put("site", "stackoverflow");
		new badgeID(0,queryParam,200).getBadgeID();
	}
	
	@Test
	public void badgeIDWithInvalidSite() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "rank");
		queryParam.put("site", "stackoverflow100");
		new badgeID(0,queryParam,400).getBadgeID();
	}
	
	@Test
	public void badgeIDWithInvalidOrder() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc123");
		queryParam.put("sort", "rank");
		queryParam.put("site", "stackoverflow");
		new badgeID(6505,queryParam,400).getBadgeID();
	}
	
	@Test
	public void badgeIDWithInvalidSort() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "rank45656");
		queryParam.put("site", "stackoverflow");
		new badgeID(6505,queryParam,400).getBadgeID();
	}
}
