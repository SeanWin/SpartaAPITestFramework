Feature: GET all courses

  As an API user
  I want to retrieve a list of all available courses
  So that I can view their details including stream, trainer, dates, and Spartans

  @GetAllCourses
  Scenario: verify if get all courses is working
    Given getCourses setup
    When user calls "getCourses" endpoint with "GET" HTTP request
    Then the API call got success with status code 200
    And the response header server is "Kestrel"
    And the response should contain a list of 5 courses

    And the course at index 0 should have name "TECH 300", stream "C# Dev", trainer "Phil Windridge", 7 spartans, and valid dates
    And the course at index 1 should have name "TECH 301", stream "Java Dev", trainer "Catherine French", 8 spartans, and valid dates
    And the course at index 2 should have name "TECH 302", stream "C# Test", trainer "Nish Mandal", 7 spartans, and valid dates

