package stepdefinitions;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import utilities.Common;

public class GetAPI {
	
		static RequestSpecification responseSpec;
		Response res;
		JsonPath js;
		String responseString;

	
	@Given("Payload is created")
	public void payload_is_created() {

		responseSpec = given().baseUri(Common.host)
				.header("Content-Type", Common.contenttype_header)
				.header("Authorization", Common.autorization_header)
				.log().all();		
	}

	@When("User triggers GET URL")
	public void user_triggers_get_url() {
		
		res = responseSpec.when().get(Common.getUrl).then().assertThat().statusCode(200).log().all().extract().response();
		
		responseString = res.asString();
		js = new JsonPath(responseString);
	}

	@Then("Jira issue should be retrieved successfully")
	public void jira_issue_should_be_retrieved_successfully() {		
		
		Assert.assertEquals(js.getString("key").toString(), "TBP-2");
	}
	
	@Then("Verify IssueType Name correctly retrieved")
	public void verify_issue_type_name_correctly_retrieved() {
		
		Assert.assertEquals(js.getString("fields.issuetype.name").toString(), "Story");
		
	}

	@Then("Verify IssueType Subtask correctly retrieved")
	public void verify_issue_type_subtask_correctly_retrieved() {

		Assert.assertEquals(js.getString("fields.issuetype.subtask").toString(), "false");
	}

	@Then("Verify Project ID correctly retrieved")
	public void verify_project_id_correctly_retrieved() {

		Assert.assertEquals(js.getString("fields.project.id").toString(), "10000");
	}

	@Then("Verify Project Key correctly retrieved")
	public void verify_project_key_correctly_retrieved() {

		Assert.assertEquals(js.getString("fields.project.key").toString(), "TBP");
	}

	@Then("Verify Project Name correctly retrieved")
	public void verify_project_name_correctly_retrieved() {

		Assert.assertEquals(js.getString("fields.project.name").toString(), "Test Banking Project");
	}

	@Then("Verify Project TypeKey correctly retrieved")
	public void verify_project_type_key_correctly_retrieved() {

		Assert.assertEquals(js.getString("fields.project.projectTypeKey").toString(), "software");
	}

	@Then("Verify Project Simplified correctly retrieved")
	public void verify_project_simplified_correctly_retrieved() {

		Assert.assertEquals(js.getString("fields.project.simplified").toString(), "false");
	}

	
}









