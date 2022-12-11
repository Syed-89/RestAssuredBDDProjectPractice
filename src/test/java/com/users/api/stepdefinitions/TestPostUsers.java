package com.users.api.stepdefinitions;

import static org.testng.Assert.assertEquals;

import com.users.api.helpers.PostServiceHelper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TestPostUsers {
	
	PostServiceHelper createUser = new PostServiceHelper();
	int status_code=0;

	@When("add a new user {int} and fname {string} and lname {string} and email {string} and street {string}")
	public void add_a_new_user_peter_kevin_peter_gmail_com(int id, String first_name, String last_name, String email, String address) {
		Response data=createUser.createUser(id, first_name, last_name, email,address);
             status_code+=status_code+data.statusCode();
	}
	@Then("the status code should {int}")
	public void the_status_code_should(int responseStatusCode) {
		assertEquals(responseStatusCode, status_code);
	}

}
