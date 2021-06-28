import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//Validate Response Code

public class Tc001_Get_Request 
{
	@Test
	void getMethod()
	{
		//Specify Base URI
		RestAssured.baseURI="https://gorest.co.in/public-api/posts";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response httpResponse = httpRequest.request(Method.GET,"/84");
		
		//Print Response in Console Window
		String ResponseBody = httpResponse.getBody().asString();
		
		//Print Response in Console
		System.out.println("Respone Body is"+ ResponseBody);
		
		//Print Response Code
		int ResponseCode = httpResponse.getStatusCode();
		System.out.println("Status code is" + ResponseCode);
		
		//Validate Response Code
		Assert.assertEquals(ResponseCode,200);
		
		//Validate Status Line
		String StatusLine = httpResponse.getStatusLine();
		System.out.println("Status Line is"+ StatusLine);
		Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
	}
}
