Feature: Create Spartan

  As an API user
  I want to create new Spartans using the API
  So that I can add new records into the system

  @DeleteSpartanAfter
  @TokenRequired
  @Happy
  Scenario: Successfully create a new Spartan
    Given spartan endpoint is up and user is authenticated
    And spartan payload with  first name "firstName" last name "lastName" course stream name "C# Test" and rest valid fields
    When user calls "spartan" endpoint with "POST" HTTP request
    Then the API responds with status code 201 and verify with getAllSpartans that the last spartan has first name "firstName" last name "lastName" course stream name "C# Test"

  @TokenRequired
  @Sad
  Scenario: Fail to create a Spartan with missing/invalid mandatory fields
    Given spartan endpoint is up and user is authenticated
    And spartan payload with  first name "first" last name "last" course stream name "" and rest valid fields
    When user calls "spartan" endpoint with "POST" HTTP request
    Then the API responds with status code 400
    And "title" in response body is "One or more validation errors occurred."
    And the validation error for "FirstName" at index 0 should be "The field FirstName must be a string with a minimum length of 6 and a maximum length of 50."
    And the validation error for "LastName" at index 0 should be "The field LastName must be a string with a minimum length of 6 and a maximum length of 50."
    And the validation error for "Course.Stream.Name" at index 0 should be "The Name field is required."
    And the validation error for "Course.Stream.Name" at index 1 should be "The field Name must be a string with a minimum length of 6 and a maximum length of 50."