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
import pojoClasses.badgeIDResponse;
import propertyInitializer.initializeConfiguration;
import reporter.logToExtentReport;

public class badgeID extends initializeConfiguration
{
	Map<String, Object> queryParam;
	int ID;
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
	 * @param ID	It takes the ID as input, having dataType as Integer
	 * @param queryParam	It takes the query parameters as Map, with Key and Value pairs
	 * @param expectedStatusCode	It takes the values of the Expected status code, from the user
	 * @throws IOException 
	 */
	
	
	public badgeID(int ID, Map<String, Object> queryParam, int expectedStatusCode) throws IOException
	{
		this.propC=super.propC;
		this.ID=ID;
		this.queryParam=queryParam;
		this.expectedStatusCode=expectedStatusCode;
	}
	
	public void getBadgeID() throws StreamWriteException, DatabindException, IOException
	{
		baseURI=propC.getProperty("BaseAPIUrl");
		basePath=propC.getProperty("BaseAPIPath");
		
		given()
			.queryParams(queryParam)
			.filter(new RequestLoggingFilter(requestCapture))
			.filter(new ResponseLoggingFilter(responseCapture))
		.when()
			.get(String.valueOf(ID));
		
		new logToExtentReport().logAPIlogsToExtentReport(requestWriter,requestCapture,responseWriter,responseCapture,"Get Badge ID",expectedStatusCode);
			
	}
	
	public void getBadgeID(String methodName) throws StreamWriteException, DatabindException, IOException
	{
		baseURI=propC.getProperty("BaseAPIUrl");
		basePath=propC.getProperty("BaseAPIPath");
		
		badgeIDResponse response = given()
			.queryParams(queryParam)
			.filter(new RequestLoggingFilter(requestCapture))
			.filter(new ResponseLoggingFilter(responseCapture))
		.when()
			.get(String.valueOf(ID))
		.then()
			.extract().response().as(badgeIDResponse.class);
		
		new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File(System.getProperty("user.dir")+"//OutputJSON//BadgeID//badgeIDResponse_"+methodName+".json"), response);
		
		new logToExtentReport().logAPIlogsToExtentReport(requestWriter,requestCapture,responseWriter,responseCapture,"Get Badge ID",expectedStatusCode);
			
	}
}

