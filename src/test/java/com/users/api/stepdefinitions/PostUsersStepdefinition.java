package com.users.api.stepdefinitions;
  
import static org.testng.Assert.assertEquals;

import java.util.List;

import com.users.api.helpers.PostServiceHelper;
import com.users.api.model.Users;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

  
  public class PostUsersStepdefinition {
  
  PostServiceHelper createUser = new PostServiceHelper(); 
  int status_code=0;
  
  @When("add a new user {int} and fname {string} and lname {string} and email {string} and street {string}") 
  public void add_a_new_user(int id, String first_name, String last_name,String email, String address) {
	  
   Response data=createUser.createUser(id,first_name, last_name, email,address);
   status_code+=data.getStatusCode();
   Users user= data.as(Users.class);
   String firstName=user.getFirstName();
   System.out.println(firstName);
   
   }

  
  @Then("the status code should {int}")
  public void the_status_code_should(int responseStatusCode) {
	  
	  assertEquals(status_code,responseStatusCode); 
	  
  }
  }
 