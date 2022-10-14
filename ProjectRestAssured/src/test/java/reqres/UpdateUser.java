package reqres;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UpdateUser {
	
	public static  HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod 
	public void putData() {
	map.put("name", "Govardhan");
	map.put("job","zion resident");
	RestAssured.baseURI = "https://reqres.in";
	RestAssured.basePath = "/api/users/2";
	

}
	@Test
	public void updateResource() {
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
			.when()
				.put()
					.then()
						.statusCode(200)
						.log().all();
	}
	
}
