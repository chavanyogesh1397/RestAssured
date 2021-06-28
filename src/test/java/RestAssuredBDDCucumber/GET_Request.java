package RestAssuredBDDCucumber;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

/*	given() - Precondition
 * 	when() - Request
 * 	then() - Validation
 */

public class GET_Request 
{

	@Test
	public void demo_Get_Request()
	{
		given()
		.when()
			.get("https://dummy.restapiexample.com/api/v1/19")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("employee_salary", equalTo("237500"))
		.header("content-type", "application/json");
		
	}
	
}
