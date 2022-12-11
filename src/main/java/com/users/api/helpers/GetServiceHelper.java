package com.users.api.helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.user.api.utils.ConfigManager;
import com.users.api.constants.EndPoints;
import com.users.api.model.Users;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetServiceHelper {
	
	private static final String Base_Url=ConfigManager.getInstance().getString("baseurl");
	

	public GetServiceHelper()
	{
		
		RestAssured.baseURI=Base_Url;
		
	}
	
	public Response response()
	{
		Response response=RestAssured
				.given().log().all()
				.contentType(ContentType.JSON)
				.get(EndPoints.Get_Single_User)
		        .andReturn();
		
		return response;		
	}
	
	
	public List<Users> getUsers()
	{
			
		Type type=new TypeReference<List<Users>>() {}.getType();		
		List<Users> user=response().as(type);
		return user;
		
	}
	
	public int getStatusCode()
	{
		
		int statuscode=response().getStatusCode();
		return statuscode;
		
	}
	
	
	public String getfirstName(int userId)
	{	
	   Users[] user=response().as(Users[].class);
	
		int length=user.length-1;
		
		for(int i=0; i<=length; i++)
		{
			if(user[i].getId()==userId)   
		     return user[i].getFirstName(); 
		}
		
		return "No such user found";
  
}
	
	public String getlastName(int userId)
	{	
		  Users[] user=response().as(Users[].class);
			
			int length=user.length-1;
			
			for(int i=0; i<=length; i++)
			{
				if(user[i].getId()==userId)   
			     return user[i].getLastName(); 
				
			}
			
			return "No such user found";	
	}
	
	public int userCount()
	{
		
		int size=getUsers().size();
		return size;
	
	}
	
	public String getEmailAddress(int id)
	{
		
		Users[] user= response().as(Users[].class);
	    int length=user.length;
	    for(int i=0; i<length; i++)
	    {
		 if(user[i].getId()==id)
		 {
			 
			 return user[i].getEmail();
			 
		 }
		
     	 }
		return "No such email found";
	}
}
