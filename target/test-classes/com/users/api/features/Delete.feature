Feature: Perform delete operations

Scenario: Delete the user
When delete this user details "/27"
Then verify the status code 200

