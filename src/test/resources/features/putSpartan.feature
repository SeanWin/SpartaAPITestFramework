Feature: Update Spartan

  As an API user
  I want to update an existing Spartan's details
  So that I can modify the record in the system

  @DeleteSpartanAfter
  @TokenRequired
  @Happy
  Scenario: Successfully update an existing Spartan with valid details
    Given spartan endpoint is up and user is authenticated
    And user called "spartan" endpoint with "POST" method and created spartan with ID 34 first name "firstName" last name "lastName" course stream name "C# Test" and rest valid fields
    And spartan payload with  first name "updatedFirstName" last name "updatedLastName" course stream name "C# Test" and rest valid fields
    When user calls "spartanById" endpoint with "PUT" HTTP request for course ID 34
    Then the API responds with status code 204
    And verify with getSpartan the spartan at ID 34 has first name "updatedFirstName" last name "updatedLastName" course stream name "C# Test"

  @TokenRequired
  @Sad
  Scenario: Fail to update, spartan not found
    Given spartan endpoint is up and user is authenticated
    And spartan payload with  first name "updatedFirstName" last name "updatedLastName" course stream name "C# Test" and rest valid fields
    When user calls "spartanById" endpoint with "PUT" HTTP request for course ID 34
    Then the API responds with status code 404
    And "title" in response body is "Not Found"

  @TokenRequired
  @Sad
  Scenario: Fail to update, id mismatch
    Given spartan endpoint is up and user is authenticated
    And spartan payload with id 35 first name "updatedFirstName" last name "updatedLastName" course stream name "C# Test" and rest valid fields
    When user calls "spartanById" endpoint with "PUT" HTTP request for course ID 34
    Then the API responds with status code 400
    And "title" in response body is "Bad Request"

  @TokenRequired
  @Sad
  Scenario: Fail to update, missing/invalid mandatory fields
    Given spartan endpoint is up and user is authenticated
    And spartan payload with  first name "first" last name "last" course stream name "" and rest valid fields
    When user calls "spartanById" endpoint with "PUT" HTTP request for course ID 34
    Then the API responds with status code 400
    And "title" in response body is "One or more validation errors occurred."

    And the validation error for "FirstName" at index 0 should be "The field FirstName must be a string with a minimum length of 6 and a maximum length of 50."
    And the validation error for "LastName" at index 0 should be "The field LastName must be a string with a minimum length of 6 and a maximum length of 50."
    And the validation error for "Course.Stream.Name" at index 0 should be "The Name field is required."
    And the validation error for "Course.Stream.Name" at index 1 should be "The field Name must be a string with a minimum length of 6 and a maximum length of 50."