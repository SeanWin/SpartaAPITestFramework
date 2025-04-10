Feature: GET all courses

  As an API user
  I want to retrieve a list of all available courses
  So that I can view their details including stream, trainer, dates, and Spartans

  @GetAllCourses
  Scenario: verify if get all courses is working
    Given getCourses setup
    When user calls "getCourses" endpoint with "GET" HTTP request
    Then the API call got success with status code 200
    And the response should contain a list of 5 courses