package com.users.api.helpers;

import com.user.api.utils.ConfigManager;
import com.users.api.constants.EndPoints;
import com.users.api.model.Users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostServiceHelper {
	
	private static final String Base_Url=ConfigManager.getInstance().getString("baseurl");

	
	public PostServiceHelper()
	{
				
		RestAssured.baseURI=Base_Url;		
	}
	
	public Response createUser(int id, String first_name, String last_name, String email, String address)
	{
		Users data = new Users();
		data.setId(id);
		data.setFirstName(first_name);
		data.setLastName(last_name);
		data.setEmail(email);
		data.setAddress(address);
		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(data)
				.post(EndPoints.Create_User)
				.andReturn();
		return response;
	}
				
		
		}
		
	

