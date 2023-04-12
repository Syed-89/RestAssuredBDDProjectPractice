Feature: Perform post operations

Scenario Outline: Create a new user
When add a new user <id> and fname "<first_name>" and lname "<last_name>" and email "<email>" and street "<address>"
Then the status code should 201 
Examples: 
|id |first_name |last_name |email| |address|
|7 |William |Watson | william@gmail.com| |St 23 Texas|
|8 |Anderson |Alex | anderson@gmail.com| |St 24 Texas|
|9 |Jackson |Peter | jakson@gmail.com| |St 25 Chicago|
|10 |Warren |Kevin | warren@gmail.com| |St 26 New Boston|
|11 |karen |Paul | karen@gmail.com| |St 27 Washington|