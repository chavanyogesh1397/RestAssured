package RestAssuredExamples;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class ValidateEmployeeData extends BaseTest
{
	@BeforeClass
	void getAllEmployeeData()
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
	}
	
	@Test
	void validateResponseBody()
	{
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		Assert.assertTrue(ResponseBody!=null);
	}
	
	@Test
	void validateStausCode()
	{
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void validateStatusLine()
	{
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void validateContentTypeHeader()
	{
		String contentType = response.header("content-type");
		System.out.println(contentType);
		Assert.assertEquals(contentType, "application/json");
	}
}
