package apiAutomation;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basePath;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.output.WriterOutputStream;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import pojoClasses.badgeReceipentResponse;
import propertyInitializer.initializeConfiguration;
import reporter.logToExtentReport;

public class badgeReceipent extends initializeConfiguration
{
	Map<String, Object> queryParam;
	int expectedStatusCode;
	Properties propC;
	
	StringWriter requestWriter = new StringWriter();	
	@SuppressWarnings("deprecation")
	PrintStream requestCapture = new PrintStream(new WriterOutputStream(requestWriter));

	StringWriter responseWriter = new StringWriter();	
	@SuppressWarnings("deprecation")
	PrintStream responseCapture = new PrintStream(new WriterOutputStream(responseWriter));
	
	/**
	 * 
	 * @param queryParam	It takes the query parameters as Map, with Key and Value pairs
	 * @param expectedStatusCode	It takes the values of the Expected status code, from the user
	 */
	public badgeReceipent(Map<String, Object> queryParam, int expectedStatusCode) throws IOException
	{
		this.propC=super.propC;
		this.queryParam=queryParam;
		this.expectedStatusCode=expectedStatusCode;
	}
	
	
	public void getBadgeReceipent() throws StreamWriteException, DatabindException, IOException
	{
		baseURI=propC.getProperty("BaseAPIUrl");
		basePath=propC.getProperty("BaseAPIPath");
		
		given()
			.queryParams(queryParam)
			.filter(new RequestLoggingFilter(requestCapture))
			.filter(new ResponseLoggingFilter(responseCapture))
		.when()
			.get("https://api.stackexchange.com/2.3/badges/recipients");
		
		new logToExtentReport().logAPIlogsToExtentReport(requestWriter,requestCapture,responseWriter,responseCapture,"Get Badge Receipent",expectedStatusCode);
	}
	
	public void getBadgeReceipent(String methodName) throws StreamWriteException, DatabindException, IOException
	{
		baseURI=propC.getProperty("BaseAPIUrl");
		basePath=propC.getProperty("BaseAPIPath");
		
		badgeReceipentResponse response = given()
			.queryParams(queryParam)
			.filter(new RequestLoggingFilter(requestCapture))
			.filter(new ResponseLoggingFilter(responseCapture))
		.when()
			.get("/recipients")
		.then()
			.extract().response().as(badgeReceipentResponse.class);
				
		new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File(System.getProperty("user.dir")+"//OutputJSON//BadgeReceipent//badgeReceipentResponse_"+methodName+".json"), response);
		
		new logToExtentReport().logAPIlogsToExtentReport(requestWriter,requestCapture,responseWriter,responseCapture,"Get Badge Receipent",expectedStatusCode);
	}
}

