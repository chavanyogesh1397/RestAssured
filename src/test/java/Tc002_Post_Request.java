import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc002_Post_Request 
{
	@Test
	void postMethod()
	{
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Creating Object of JSONObject class for passing the body
		
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", "morpheus");
		requestparam.put("job", "leader");
	
		
		//Creating Header
		httpRequest.header("Content-Type", "application/json");
		
		//attach above data to the request
		httpRequest.body(requestparam.toJSONString());
		
		//Response Object
		Response Response = httpRequest.request(Method.POST,"/users");
		
		//Print Response in console
		int StatusCode = Response.getStatusCode();
		System.out.println(StatusCode);
		
		//Print success Code
		String successCode = Response.jsonPath().get("SuccessCode");
		System.out.println("Success code "+ successCode);
		
		String line = Response.getStatusLine();
		System.out.println("status line "+ line);
	}
}
