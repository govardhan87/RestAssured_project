package projectGorest;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Projectlog4jdemo.ProjectBaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class CreateUpdateDeleteUser extends ProjectBaseTest {
	
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	UUID uuid = UUID.randomUUID();
	String id;
	
	@Test (priority = 0)
	public void postData() {
		map.put("name", "Govardhan");
		logger.info("Added name");
		map.put("email", "govardhanah"+ uuid + "@gmail.com");
		logger.info("Added, email");
		map.put("gender", "male");
		logger.info("Added gender");
		map.put("status", "active");
		logger.info("Added status");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "/public/v2/users";
		logger.info("Payload created for creating the resource");	

}
	@Test (priority = 1)
 	public void createUser() {
	 		
	 	Response response = RestAssured
	 
				.given()
			.contentType("application/json")
			.body(map)
			.headers("Authorization","Bearer 877e8cf33d06c70d5f89cec48965e31fb23778501e0237a096e420a179b96dbf")
		.when()
			.post()
		.then()
			.log().all()
			.contentType(ContentType.JSON).extract().response();
	 	logger.info("Resource created and Response captured");

	           JsonPath jsonPath = response.jsonPath();
	          logger.info("JSON path created");

              System.out.println("Response = " + jsonPath.get("id"));
              id = jsonPath.get("id").toString();
              logger.info("Resource id Captured");
}
	@Test(priority = 2)
	public void updateUser () {
		map.put("name", "govardhan A H");
		map.put("email", "govardhanah5555@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "/public/v2/users/" + id;
		logger.info("Payload created for creating the resource");
		
		RestAssured
		.given()
			.contentType("application/json")
				.body(map)
				.header("Authorization", "Bearer 877e8cf33d06c70d5f89cec48965e31fb23778501e0237a096e420a179b96dbf")
					.when()
				.put()
					.then()
						.statusCode(200)
						.log().all()
							.and()
						.body("name", is("govardhan A H"));	
	logger.info("Resource updated");
				
}
	@Test (priority = 3)
	public void deleteResource() {
	RestAssured.baseURI = "https://gorest.co.in/";
	RestAssured.basePath = "/public/v2/users/" + id;
	
	RestAssured
		.given()
			.contentType("application/json")
			.header("Authorization", "Bearer 877e8cf33d06c70d5f89cec48965e31fb23778501e0237a096e420a179b96dbf")
		.when()
			.delete()
				.then()
				.statusCode(204);
				logger.info("Resource deleted");

	
}
}

