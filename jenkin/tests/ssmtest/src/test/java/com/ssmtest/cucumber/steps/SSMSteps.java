package com.ssmtest.cucumber.steps;

import com.ssmtest.cucumber.serenity.SSMSerenitySteps;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class SSMSteps {
    @Steps
    SSMSerenitySteps steps;

    static String servicename=null;

    @When("^User sends a GET request to list, then the application must provide a valid response$")
    public void user_sends_a_GET_request_to_list_then_the_application_must_provide_a_valid_response() throws Throwable {

        SerenityRest.rest().given()
                .when()
                .get("/listAll")
                .then();

    }



}
