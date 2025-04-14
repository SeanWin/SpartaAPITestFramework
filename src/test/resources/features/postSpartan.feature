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
    Then the API responds with status code 500
    And verify with getAllSpartans that the last spartan has first name "firstName" last name "lastName" course stream name "C# Test"