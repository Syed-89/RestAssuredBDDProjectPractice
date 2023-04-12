package com.users.api.runner;
import org.testng.annotations.BeforeSuite;

import com.user.api.utils.FileSystem;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/com/users/api/features"},
		glue = {"com.users.api.stepdefinitions"},
		plugin = {"pretty"}					
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	@BeforeSuite
	public void beforeSuite()
	{	
		FileSystem.deleteOldReports();	
	}

}
