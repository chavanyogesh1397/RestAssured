package BddPractice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; 


public class GeTClassBDD 
{
	@Test
	public void testbddcucumber()
	{
		given()
		.when().get("https://gorest.co.in/public-api/posts/84")
		.then()
		.statusCode(200);
		
	}
}
