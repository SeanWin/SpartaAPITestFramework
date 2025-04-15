Feature: Get Spartan By ID

  As an API user
  I want to retrieve details of a specific Spartan by ID
  So that I can verify that the returned data is correct

  @TokenRequired
  @Happy
  Scenario: Retrieve Spartan by valid ID
    Given spartan endpoint is up and user is authenticated
    When user calls "spartanById" endpoint with "GET" HTTP request for ID 1
    Then the API responds with status code 200
    And the response header server is "Kestrel"
    And the spartan should have first name "Sparty", last name "McFly", university "University of Rome", degree "Time Travel", course "TECH 300", stream "C# Dev", and graduated "false"

  @TokenRequired
  @Sad
  Scenario: Retrieve Spartan with an invalid ID
    Given spartan endpoint is up and user is authenticated
    When user calls "spartanById" endpoint with "GET" HTTP request for ID 99
    Then the API responds with status code 204
    And the response header server is "Kestrel"