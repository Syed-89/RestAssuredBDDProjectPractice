  package com.users.api.stepdefinitions;
  
  import static org.testng.Assert.assertEquals;
  
  import com.users.api.helpers.DeleteServiceHelper;
  
  import io.cucumber.java.en.Then; import io.cucumber.java.en.When;
  
  public class DeleteUsersStepDefinition {
  
  
  DeleteServiceHelper deleteUser= new DeleteServiceHelper(); 
  private int responseStatusCode;
  
  @When("delete this user details {string}") 
  public void delete_this_user_details(String pathParam) {

	  responseStatusCode+=responseStatusCode+deleteUser.reponse(pathParam).
	  getStatusCode(); 
	  
  }
  
  
  @Then("verify the status code {int}") 
  public void verify_the_status_code(int statusCode) {
	  
	  assertEquals(responseStatusCode, statusCode);
  
  }
  }
  
 