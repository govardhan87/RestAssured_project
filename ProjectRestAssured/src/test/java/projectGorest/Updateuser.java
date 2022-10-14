package projectGorest;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Updateuser {

public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeTest
	public void postData() {
		map.put("name", "govardhan A H");
		map.put("email", "govardhanah5555@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "/public/v2/users/3026";

}
	@Test
	public void updateResource() {
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
	}
}
