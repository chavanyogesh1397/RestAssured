import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Tc003_Get_HeaderValidatingRequest 
{
	@Test
	void validateHeader()
	{
		//Creating base URI
		RestAssured.baseURI="https://gorest.co.in/public-api/posts";
		
		//Creating request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//creating response
		Response response = httpRequest.request(Method.GET,"/84");
		
		//Printing Response Boby
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		//validating headers
		String contentType = response.header("content-type");
		System.out.println(contentType);
		Assert.assertEquals("application/json; charset=utf-8", contentType);
		
		String ContentEncoding = response.header("content-encoding");
		System.out.println(ContentEncoding);
		Assert.assertEquals("gzip",ContentEncoding);
	}
}
