package RestAssuredExamples;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import UtilityPackage.RestUtil;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class CreateNewRecord_Post extends BaseTest
{
	String empName = RestUtil.empName();
	String empSal = RestUtil.empSalary();
	String Empage = RestUtil.empAge();
			
	@BeforeClass
	void validatePostMethod() throws InterruptedException
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		httpRequest = RestAssured.given();
		
		JSONObject param = new JSONObject();
		param.put("name", empName);
		param.put("salary", empSal);
		param.put("age", Empage);
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(param.toJSONString());
		
		response = httpRequest.request(Method.POST,"/create");
		
		Thread.sleep(5000);
	}
	
	@Test
	void verifyStatusBody()
	{
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertTrue(responseBody.contains(empName));
	}
	
	@Test
	void verifyStatusCode() 
	{
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void verifyStatusLine() 
	{
		String statusline = response.statusLine();
		System.out.println(statusline);
	}
	@Test
	void verifyContentType()
	{
		String conttype = response.contentType();
		Assert.assertEquals(conttype, "application/json");
	}
	
	@Test
	void contentEncoding()
	{
		String contentEncoding = response.header("content-encoding");
		Assert.assertEquals(contentEncoding, "gzip");
	}
}
