package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AuthenticationBody;
import pojo.Course;
import pojo.Spartan;
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
    static String token;
    Spartan[] spartans;

    @Given("getCourses setup")
    public void get_courses_setup() throws IOException {
        res = given().spec(requestSpecification());
    }

    @Given("authentication body payload with username {string} and password {string}")
    public void authentication_body_payload_with_username_and_password(String username, String password) throws IOException {
        res = given().spec(requestSpecification())
                .body(new AuthenticationBody(username, password));
    }

    @Given("spartan endpoint is up and user is authenticated")
    public void spartan_endpoint_is_up_and_user_is_authenticated() throws IOException {
       res = given().spec(requestSpecification()).header("Authorization", "Bearer " + token);
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

    @When("user calls {string} endpoint with {string} HTTP request for course ID {int}")
    public void user_calls_endpoint_with_http_request_for_course_id(String resource, String method, Integer id) {
        APIResources resourcesApi = APIResources.valueOf(resource);
        System.out.println(resourcesApi.getResource().substring(0,13).concat(id.toString()));
        res.pathParam("id", id);

        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("PUT")) {
            response = res.when().post(resourcesApi.getResource());
        }
        else if(method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourcesApi.getResource());
        }
        else if(method.equalsIgnoreCase("DELETE")) {
            response = res.when().delete(resourcesApi.getResource());
        }
    }

    @Then("the API responds with status code {int}")
    public void the_api_responds_with_status_code(Integer expectedCode) {
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

    @Then("the course should have name {string}, stream {string}, trainer {string}, {int} spartans, and valid dates")
    public void the_course_should_have_name_stream_trainer_spartans_and_valid_dates(String expectedName, String expectedStream, String expectedTrainer, Integer expectedSpartanCount) {
        course = response.as(Course.class);

        assertAll(
                () -> assertEquals(expectedName, course.getName()),
                () -> assertEquals(expectedStream, course.getStream()),
                () -> assertEquals(expectedTrainer, course.getTrainer()),
                () -> assertEquals(expectedSpartanCount, course.getSpartans().size()),
                () -> assertTrue(isStartDateBeforeEndDate(course.getStartDate(), course.getEndDate()), "Start date should be before end date")
        );
    }

    @Then("the response contains an authentication token")
    public void the_response_contains_an_authentication_token() {
        token = getJsonPath(response, "token");
        assertAll(
                () -> assertNotNull(token),
                () -> assertFalse(token.isEmpty()),
                () -> assertEquals(3, token.split("\\.").length)
        );
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        assertEquals(expectedValue,getJsonPath(response,keyValue));
    }

    @Then("the response should contain a list of {int} spartans")
    public void the_response_should_contain_a_list_of_spartans(Integer expectedNumberOfSpartans) {
        spartans = response.as(Spartan[].class);
        assertEquals(expectedNumberOfSpartans, spartans.length);
    }

}
