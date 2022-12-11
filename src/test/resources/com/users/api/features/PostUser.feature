Feature: Perform post operations

Scenario Outline: Create a new user
When add a new user <id> and fname "<first_name>" and lname "<last_name>" and email "<email>" and street "<address>"
Then the status code should 201 
Examples: 
|id |first_name |last_name |email| |address|
|1 |Paul |watson | paul@gmail.com| |St 23 Texas|
|2 |Sandra |Alex | sandra@gmail.com| |St 24 Texas|
|3 |Julia |Peter | julia@gmail.com| |St 25 Chicago|
|4 |Andrew |Waston | andrew@gmail.com| |St 26 New Boston|
|5 |Anglea |Paul | anglea@gmail.com| |St 27 Washington|