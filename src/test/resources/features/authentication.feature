Feature: User Authentication

  As a registered user
  I want to authenticate with the API
  So that I can receive a valid token and access protected Spartan endpoints

  @Happy
  Scenario: Successful login with valid credentials
    Given authentication body payload with username "sparta" and password "global"
    When user calls "authentication" endpoint with "POST" HTTP request
    Then the API responds with status code 200
    And the response header server is "Kestrel"
    And the response contains an authentication token

  @Sad
  Scenario: Unsuccessful login with invalid credentials
    Given authentication body payload with username "username" and password "password"
    When user calls "authentication" endpoint with "POST" HTTP request
    Then the API responds with status code 401
    And the response header server is "Kestrel"
    And "title" in response body is "Unauthorized"