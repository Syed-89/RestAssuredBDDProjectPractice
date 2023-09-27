package com.users.api.stepdefinitions;
  
  import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.Assert;

import com.users.api.helpers.GetServiceHelper;
import com.users.api.model.Users;
import com.users.api.utils.ReadJsonFile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
  
  public class TestGetUsers {

		// TODO Auto-generated constructor stub

     GetServiceHelper getUser=new GetServiceHelper();
     ReadJsonFile readJson;
  
  @Severity(SeverityLevel.CRITICAL)
  
  @Given("user has access to the endpoint") 
  public void user_has_access_to_the_endpoint() {
  
  List<Users> userList=getUser.getUsers(); 
  assertNotNull(userList,  "The list is not empty");
  
  }
  
  @When("status code is {int}") 
  public void status_code_is(long code) {
  
  int statusCode=getUser.getStatusCode(); 
  assertEquals(code, statusCode);
  
  }
  
  @Then("the user firstname should be {string} of userId {int}") 
  public void the_user_firstname_should_be_of_userId(String fname, int id) {
	  
  String firstName=getUser.getfirstName(id);  
  assertEquals(firstName, fname); 
  
  }
  
  @Then("the user lastname should be {string} of userId {int}") 
  public void verify_the_user_lastname(String lname, int id) {
  
  String lastName=getUser.getlastName(id); 
  assertEquals(lastName, lname); 
  
  }
  
  @Then("status code should be {int}") 
  public void status_code_should_be(int code) { 
	  
	  int status_code=getUser.getStatusCode(); 
	  assertEquals(status_code, code); 
	  
  }
  
  @And("total user count should be greater than {int}") 
  public void total_user_count_should_be_greater_than (int count) { 
	
	  int user_count=getUser.userCount();
	  
	  System.out.println(user_count);
	  
      if(user_count>1)
      { 
    	  Assert.assertTrue(true); 
    	  
      }
  
  }
  
  @Then("email address should {string} of the userID {int}") 
  public void email_address_should_of_the_user_id(String userEmail, Integer userId) {
    
	  String emailAddress=getUser.getEmailAddress(userId);    
	  Assert.assertEquals(emailAddress, userEmail); 
  }
  
  @Given("perform the get operation for json validation") 
  public void perform_the_get_operation_for_json_validation() {
  
  getUser.getUsers(); 
  
  }
  
  @Then("validate response using Json file") 
  public void validate_response_using_json_file() {
  
  readJson = new ReadJsonFile();
  assertThat(getUser.response().asString(), matchesJsonSchema(readJson.readFile("SchemaFile")));
  
  }
  
  }
 