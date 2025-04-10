package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Course;
import utils.APIResources;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefs extends Utils {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    Course[] courses;
    Course course;

    @Given("getCourses setup")
    public void get_courses_setup() throws IOException {
        res = given().spec(requestSpecification());
    }

    @When("user calls {string} endpoint with {string} HTTP request")
    public void user_calls_endpoint_with_http_request(String resource, String method) {
        APIResources resourcesApi = APIResources.valueOf(resource);
        System.out.println(resourcesApi.getResource());

        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("POST")) {
            response = res.when().post(resourcesApi.getResource());
        }
        else if(method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourcesApi.getResource());
        }
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer expectedCode) {
         assertEquals(expectedCode, response.getStatusCode());
    }

    @Then("the response header server is {string}")
    public void the_response_header_server_is(String expectedServer) {
        assertEquals(expectedServer, response.header("Server"));
    }

    @Then("the response should contain a list of {int} courses")
    public void the_response_should_contain_a_list_of_courses(Integer expectedNumberOfCourses) {
        courses = response.as(Course[].class);
        assertEquals(expectedNumberOfCourses, courses.length);
    }

    @Then("the course at index {int} should have name {string}, stream {string}, trainer {string}, {int} spartans, and valid dates")
    public void the_course_at_index_should_have_full_details(Integer index, String expectedName, String expectedStream, String expectedTrainer, Integer expectedSpartanCount) {
        course = courses[index];

        assertAll(
                () -> assertEquals(expectedName, course.getName()),
                () -> assertEquals(expectedStream, course.getStream()),
                () -> assertEquals(expectedTrainer, course.getTrainer()),
                () -> assertEquals(expectedSpartanCount, course.getSpartans().size()),
                () -> assertTrue(isStartDateBeforeEndDate(course.getStartDate(), course.getEndDate()), "Start date should be before end date")
        );
    }

}
