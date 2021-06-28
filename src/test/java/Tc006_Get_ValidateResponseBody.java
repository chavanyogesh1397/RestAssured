
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc006_Get_ValidateResponseBody 
{
	@Test
	void responseBody()
	{
		RestAssured.baseURI="https://gorest.co.in/public-api/posts";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/84");
		
		//validate Response Body
		String respnseBody = response.getBody().asString();
		
		System.out.println(respnseBody);
		
		Assert.assertEquals(respnseBody.contains("title"), true);
	}
}
