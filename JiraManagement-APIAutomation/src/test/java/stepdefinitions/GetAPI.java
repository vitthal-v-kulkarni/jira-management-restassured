package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import utilities.Common;

public class GetAPI {
	
		static RequestSpecification responseSpec;
		Response res;
		String str;

	
	@Given("Payload is created")
	public void payload_is_created() {

		responseSpec = given().baseUri(Common.host)
				.header("Content-Type", Common.contenttype_header)
				.header("Authorization", Common.autorization_header)
				.log().all();		
	}

	@When("User triggers Authentication URL")
	public void user_triggers_authentication_url() {
		
		res = responseSpec.when().get(Common.getUrl).then().assertThat().statusCode(200).log().all().extract().response();
	}

	@Then("SessionID should be generated successfully")
	public void session_id_should_be_generated_successfully() {
		
		String responseString = res.asString();
		JsonPath js = new JsonPath(responseString);		
		Assert.assertEquals(js.getString("key").toString(), "TBP-2");
	}
}
