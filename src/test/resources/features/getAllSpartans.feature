Feature: GET all Spartans

  As an API user
  I want to retrieve a list of all Spartans from the API
  So that I can verify that the data is complete and correct

  @TokenRequired
  @GetAllSpartans
  Scenario: Retrieve and validate the Spartans list
    Given spartan endpoint is up and user is authenticated
    When user calls "spartan" endpoint with "GET" HTTP request
    Then the API responds with status code 200
    And the response header server is "Kestrel"
    #And the response should contain a list of 5 spartans