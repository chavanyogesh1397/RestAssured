import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.internal.PreemptiveAuthSpecImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc005_Get_ExtractValueFromNode 
{
	@Test
	void ValidateNodeValue()
	{
		RestAssured.baseURI="https://gorest.co.in/public-api/posts";
	
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/84");
		
		String body = response.getBody().asString();
		System.out.println(body);
		//Reading value ofall nodes
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("data"));
	}
}
