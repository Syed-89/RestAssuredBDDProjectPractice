Feature: Perform get user opertations

Scenario: Verify the single user
Given user has access to the endpoint
When  status code is 200
Then  the user firstname should be "Andrew" of userId 5 
Then  the user lastname should be "Peter" of userId 4

Scenario: Verify the count of users
Then status code should be 200 
And total user count should be greater than 1

Scenario: Verify the email address of the user
Then email address should "sandra@gmail.com" of the userID 3

Scenario: Validate the json schema
Given perform the get operation for json validation
Then validate response using Json file