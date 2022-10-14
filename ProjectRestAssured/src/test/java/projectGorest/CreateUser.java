package projectGorest;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateUser {
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	UUID uuid = UUID.randomUUID();
	
	@BeforeTest
	public void postData() {
		map.put("name", "Govardhan");
		map.put("email", "govardhanah"+ uuid + "@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "/public/v2/users";

}
@Test
	
	public void createResource() {
		RestAssured
		  .given()
		       .contentType("application/json")
		       .body(map)
		       .header("Authorization","Bearer 877e8cf33d06c70d5f89cec48965e31fb23778501e0237a096e420a179b96dbf")
		       .when() 
		      		.post()
		      	.then()
		      .statusCode(201)
		      		.log().all();
}
}
