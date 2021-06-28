import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc004_Get_AllHeaders 
{
	@Test
	void getAllHeaders()
	{
		RestAssured.baseURI="https://gorest.co.in/public-api/posts";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/84");
		
		//Print All Headers
		Headers Allheaders = response.getHeaders();
		
		for(Header headr :Allheaders)
		{
			System.out.println(headr.getName()+"  "+headr.getValue());
		}
	}
}
