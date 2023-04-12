package com.users.api.helpers;

import com.user.api.utils.ConfigManager;
import com.users.api.constants.EndPoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteServiceHelper {

	private static final String Base_Url=ConfigManager.getInstance().getString("baseurl");
	
	
	public DeleteServiceHelper(){
		
		RestAssured.baseURI=Base_Url;
		
	}
	public Response reponse(String pathParam){
		
		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
				.delete(EndPoints.Delete_User+pathParam)
				.andReturn();	
		return response;
		
	}
}
