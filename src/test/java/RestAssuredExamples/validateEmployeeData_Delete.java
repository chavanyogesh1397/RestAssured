package RestAssuredExamples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class validateEmployeeData_Delete extends BaseTest
{
	@BeforeClass
	void validateDeleteEmployeeData()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.DELETE,"/delete/"+EmpId);
	}
	@Test
	void validateStatusCode()
	{
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}
}
