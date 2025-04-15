Feature: Delete Spartan by ID

  As an API user
  I want to delete an existing spartan by ID
  So that the spartan is no longer retrievable from the system

  @TokenRequired
  @Happy
  Scenario: Successfully delete a spartan by ID
    Given spartan endpoint is up and user is authenticated
    And user called "spartan" endpoint with "POST" method and created spartan with ID 34 first name "firstName" last name "lastName" course stream name "C# Test" and rest valid fields
    When user calls "spartanById" endpoint with "DELETE" HTTP request for ID 34
    Then the API responds with status code 204

  @TokenRequired
  @Sad
  Scenario: Fail to delete, spartan not found
    Given spartan endpoint is up and user is authenticated
    When user calls "spartanById" endpoint with "DELETE" HTTP request for ID 34
    Then the API responds with status code 404
    And "title" in response body is "Not Found"