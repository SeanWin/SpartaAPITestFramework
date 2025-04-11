Feature: GET course by ID

  As an API user
  I want to retrieve details of a specific course by its ID
  So that I can view their details including stream, trainer, dates, and Spartans

  @Happy
  Scenario: Verify course details returned by valid course ID
    Given getCourses setup
    When user calls "getCourses" endpoint with "GET" HTTP request for course ID 1
    Then the API responds with status code 200
    And the response header server is "Kestrel"
    And the course should have name "TECH 300", stream "C# Dev", trainer "Phil Windridge", 7 spartans, and valid dates