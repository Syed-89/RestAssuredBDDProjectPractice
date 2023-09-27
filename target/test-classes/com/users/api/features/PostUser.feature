Feature: Perform post operations

Scenario Outline: Create a new user
When add a new user <id> and fname "<first_name>" and lname "<last_name>" and email "<email>" and street "<address>"
Then the status code should 201 
Examples: 
|id |first_name |last_name |email| |address|
|29 |Peter |Albert | albert@gmail.com| |St 23 Texas|
|30 |Bardon |Watson | watson@gmail.com| |St 23 Texas|