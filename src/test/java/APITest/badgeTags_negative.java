package APITest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import apiAutomation.badgeTags;
import reporter.testListener;

public class badgeTags_negative
{
	@BeforeClass
	public void initializeProperties()
	{
		testListener.test = testListener.suite.createNode(this.getClass().getSimpleName());
	}

	@Test
	public void badgeTagsWithInvalidOrder() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "descweqw");
		queryParam.put("sort", "rank");
		queryParam.put("site", "stackoverflow");
		new badgeTags(queryParam,400).getBadgeTags();
	}

	@Test
	public void badgeTagsWithInvalidSort() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "rank32423");
		queryParam.put("site", "stackoverflow");
		new badgeTags(queryParam,400).getBadgeTags();
	}
	
	@Test
	public void badgeTagsWithInvalidSite() throws StreamWriteException, DatabindException, IOException
	{
		Map<String, Object> queryParam = new HashMap<String, Object>();
		queryParam.put("order", "desc");
		queryParam.put("sort", "rank32423");
		queryParam.put("site", "stackove12313rflow");
		new badgeTags(queryParam,400).getBadgeTags();
	}
}
