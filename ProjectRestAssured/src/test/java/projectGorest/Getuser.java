package projectGorest;

import static org.hamcrest.Matchers.is;

import io.restassured.RestAssured;

public class Getuser {
	
	public void getResource() {
		RestAssured
			.given()
				.contentType("application/json")
				.header("Authorization","Bearer 877e8cf33d06c70d5f89cec48965e31fb23778501e0237a096e420a179b96dbf")
			.when()
			.get("https://gorest.co.in/public/v2/users/3023")
				.then()
					.statusCode(201)

					.log().all()
					.and()
						.body("email", is("govardhanah555@gmail.com"));
	}

}
