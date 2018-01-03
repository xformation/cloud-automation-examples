package com.userTest.cucumber.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.user.Model.Autherity;
import com.user.Model.UserClass;
import com.userTest.cucumber.serenity.UserSerenitySteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class ServiceSteps {
    @Steps
    UserSerenitySteps steps;

    static String servicename=null;

    @When("^User sends a GET request to list, then the application must provide a valid response$")
    public void user_sends_a_GET_request_to_list_then_the_application_must_provide_a_valid_response() throws Throwable {

        SerenityRest.rest().given()
                .when()
                .get("/listAll")
                .then();

    }


    @When("^I create a new user by providing the information USerName (.*) email (.*) password (.*) type (.*) $")
    public void createUser(String username, String password, String email, UserClass.Types type){
        System.out.println("The user name is "+username);
        steps.createUser(username,password,email,type)
                .statusCode(201);
    }

    /*(@Then("^I verify that the service with (.*) is created$")
    public void i_verify_that_the_service_with_servicename_is_created(String username){
        HashMap<String, Object> resVal=  steps.getServiceInfoByUserName(username);
        System.out.println("The values are : "+resVal);
        //assertThat(resVal,hasValue(emailId));
    }*/
}
