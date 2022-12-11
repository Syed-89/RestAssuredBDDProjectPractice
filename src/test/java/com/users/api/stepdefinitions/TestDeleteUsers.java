package com.users.api.stepdefinitions;

import static org.testng.Assert.assertEquals;

import com.users.api.helpers.DeleteServiceHelper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestDeleteUsers {
	
	
	DeleteServiceHelper deleteUser= new DeleteServiceHelper();
	private int responseStatusCode;
	
	@When("perform delete operation on the api {string}")
	public void perform_delete_operation_on_the_api(String pathParam) {
		responseStatusCode+=responseStatusCode+deleteUser.reponse(pathParam).getStatusCode();
	}

	
	@Then("verify the status code {int}")
	public void verify_the_status_code(int statusCode) {
		assertEquals(responseStatusCode, statusCode);
	}

}
