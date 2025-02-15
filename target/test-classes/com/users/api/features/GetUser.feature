Feature: Perform get user opertations

Scenario: Verify the single user
Given user has access to the endpoint
When  status code is 200
Then  the user firstname should be "Andrew" of userId 5 
And  the user lastname should be "Peter" of userId 4

Scenario: Verify the count of users
Then status code should be 200 
And total user count should be greater than 1

Scenario: Verify the email address of the user
Then email address should "sandra@gmail.com" of the userID 3

Scenario: Validate the json schema
Given get the user details
Then validate response using json file

Scenario Outline: Verify the user details
When get the users data
Then the user details should <id> and fname "<first_name>" and lname "<last_name>" and email "<email>" and street "<address>" 
Examples: 
|id |first_name |last_name |email| |address|
|29 |Peter |Albert | albert@gmail.com| |St 23 Texas|