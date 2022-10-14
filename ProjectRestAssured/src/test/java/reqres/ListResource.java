package reqres;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ListResource {
	
	public static  HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod
	  public void listResource() {
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/unknown";
		
	}
	
	@Test
	public void getData () {
		RestAssured
			.given()
				.contentType("application/json")
			.accept("*/*")
			
				.body(map)
			.when()
				.get()
			.then()
				.log().all()
				.statusCode(200);
			
		
	}
	
	

}
