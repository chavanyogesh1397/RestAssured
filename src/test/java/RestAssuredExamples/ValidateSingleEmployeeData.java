package RestAssuredExamples;

import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class ValidateSingleEmployeeData extends BaseTest
{
	@BeforeClass
	void validateSingleEmployeeData()
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employee/";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,EmpId);
	}
	
	@Test
	void validateSatusCode()
	{
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	@Test
	void validateStatusLine()
	{
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void validateContentType()
	{
		String contettype = response.contentType();
		System.out.println(contettype);
	}
	
	// Server Type, Content Encoding, Content Length 
	
	@Test
	void validateSeverType()
	{
		String servertype = response.header("server");
		System.out.println(servertype);
		Assert.assertEquals(servertype, "cloudflare");
	}
	@Test
	void validateResponseTime()
	{
		long responseTime = response.getTime();
		String s = Long.toString(responseTime);
		Assert.assertTrue(responseTime<=5000);
	}
	
}
