Feature: GET all Spartans

  As an API user
  I want to retrieve a list of all Spartans from the API
  So that I can verify that the data is complete and correct

  @TokenRequired
  @Happy
  Scenario: Retrieve and validate the Spartans list
    Given spartan endpoint is up and user is authenticated
    When user calls "spartan" endpoint with "GET" HTTP request
    Then the API responds with status code 200
    And the response header server is "Kestrel"
    And the response should contain a list of 33 spartans

    And the spartan at index 0 should have first name "Sparty", last name "McFly", university "University of Rome", degree "Time Travel", course "TECH 300", stream "C# Dev", and graduated "false"
    And the spartan at index 1 should have first name "John", last name "Lennon", university "Liverpool Hope University", degree "Songwriting and Composition", course "TECH 301", stream "Java Dev", and graduated "false"
    And the spartan at index 2 should have first name "Paul", last name "McCartney", university "Liverpool Institute for Performing Arts", degree "Music Production and Performance", course "TECH 302", stream "C# Test", and graduated "false"

  @Sad
  Scenario: Attempt to retrieve Spartans with an invalid token
      Given user uses an "invalid" token
      When user calls "spartan" endpoint with "GET" HTTP request
      Then the API responds with status code 401
      And the response header "WWW-Authenticate" contains "invalid_token"

  @Sad
  Scenario: Attempt to retrieve Spartans with an wrong signature token
    Given user uses an "wrong_signature" token
    When user calls "spartan" endpoint with "GET" HTTP request
    Then the API responds with status code 401
    And the response header "WWW-Authenticate" contains "invalid_token"
    And the response header "WWW-Authenticate" contains "The signature key was not found"

  @Sad
  Scenario: Attempt to retrieve Spartans with an expired token
    Given user uses an "expired" token
    When user calls "spartan" endpoint with "GET" HTTP request
    Then the API responds with status code 401
    And the response header "WWW-Authenticate" contains "invalid_token"
    And the response header "WWW-Authenticate" contains "The token expired"