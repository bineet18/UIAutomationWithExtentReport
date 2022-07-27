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

public class badgeID_positive
{
	@BeforeClass
	public void initializeProperties()
	{
		testListener.test = testListener.suite.createNode(this.getClass().getSimpleName());
	}
	
	
	@Test
	public void badgeIDWithOrderDescSortRank() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "rank");
		queryParam.put("site", "stackoverflow");
		new badgeID(6505,queryParam,200).getBadgeID(new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void badgeIDWithOrderAscSortRank() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "asc");
		queryParam.put("sort", "rank");
		queryParam.put("site", "stackoverflow");
		new badgeID(6505,queryParam,200).getBadgeID(new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void badgeIDWithSortName() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "name");
		queryParam.put("site", "stackoverflow");
		new badgeID(6505,queryParam,200).getBadgeID(new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void badgeIDWithSortType() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "type");
		queryParam.put("site", "stackoverflow");
		new badgeID(6505,queryParam,200).getBadgeID(new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void badgeIDWithMin() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "name");
		queryParam.put("site", "stackoverflow");
		queryParam.put("min", 1);
		new badgeID(6505,queryParam,200).getBadgeID(new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void badgeIDWithMax() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "name");
		queryParam.put("site", "stackoverflow");
		queryParam.put("max", 1);
		new badgeID(6505,queryParam,200).getBadgeID(new Object(){}.getClass().getEnclosingMethod().getName());
	}
}
