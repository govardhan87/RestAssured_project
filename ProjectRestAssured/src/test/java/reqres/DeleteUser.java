package reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteUser {
	
@Test
	
	public void deleteResource() {
		RestAssured.baseURI = "https://reqres.in";
	    RestAssured.basePath="/api/users/2";
	
	
	RestAssured
	.given()
	  .when()
	     .delete()
	   .then()
	      .statusCode(204);

}


}
