package projectGorest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteUser {
	
@Test
	
	public void deleteResource() {
	
	RestAssured.baseURI = "https://gorest.co.in/";
	RestAssured.basePath = "/public/v2/users/3026";
	
	RestAssured
		.given()
			.contentType("application/json")
			.header("Authorization", "Bearer 877e8cf33d06c70d5f89cec48965e31fb23778501e0237a096e420a179b96dbf")
		.when()
			.delete()
				.then()
				.statusCode(204);


}
}
