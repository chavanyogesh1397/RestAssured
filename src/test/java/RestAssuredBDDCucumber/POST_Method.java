package RestAssuredBDDCucumber;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.RestUtility;
import io.restassured.RestAssured;

@SuppressWarnings("unused")
public class POST_Method 
{
	public static HashMap map = new HashMap();
	String empName = RestUtility.empName();
	String empSal = RestUtility.empSalary();
	String empAge = RestUtility.empAge();
	
	
	@BeforeClass
	void postData()
	{
		map.put("name", empName);
		map.put("salary", empSal);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
		RestAssured.basePath="create";
	}
	
	@Test
	void validatePostMethod()
	{
		given()
			.contentType("application/json")
			.body(map)
			
		.when()
		
			.post()
		
		.then()
		
			.statusCode(200)
			.log().all();
			
	}
}
