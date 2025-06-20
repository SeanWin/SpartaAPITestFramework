package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@TokenRequired")
    public void beforeScenario() throws IOException {
        StepDefs m = new StepDefs();
        if(StepDefs.token == null) {
            m.authentication_body_payload_with_username_and_password("sparta","global");
            m.user_calls_endpoint_with_http_request("authentication","POST");
            m.the_response_contains_an_authentication_token();
        }
    }

    @After("@DeleteSpartanAfter")
    public void afterScenario() throws IOException {
        StepDefs m = new StepDefs();
        m.spartan_endpoint_is_up_and_user_is_authenticated();
        m.user_calls_endpoint_with_http_request_for_id("spartanById","DELETE",StepDefs.createdSpartanId);
    }
}
