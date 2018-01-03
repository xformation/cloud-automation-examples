package com.ssmtest.cucumber.serenity;

import com.SSM.Model.SSMClass;
import com.ssmtest.utils.ReuseableSpecifications;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class SSMSerenitySteps {

    @Step("Creating State Machine with name:{0}, target:{1}, event:{2}, action: {3}")
    public ValidatableResponse createSSM(String name, String target, String event, String action) {
        SSMClass ssm = new SSMClass();
        ssm.setName(name);
        ssm.setTarget(target);
        ssm.setEvent(event);
        ssm.setEvent(action);
        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(ssm)
                .post("/create")
                .then();
    }
    @Step("Updating SSM information with name: {0}, event: {1}, action: {2}")
    public ValidatableResponse updateSSM(String name, String event, String action){

        SSMClass ssm = new SSMClass();
        ssm.setName(name);
        ssm.setEvent(event);
        ssm.setAction(action);
        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(ssm)
                .post("/update")
                .then();
    }

    @Step("Deleting SSM  Id:{0},Name:{1}, event: {2}, action: {3}")
    public ValidatableResponse deletessm(String id, String name, String target, String event, String action){
    SSMClass ssm = new SSMClass();
        /*username=user.getUsername();
        email=user.getEmail();
        password=user.getPassword();*/
        ssm.setName(name);
        ssm.setTarget(target);
        ssm.setEvent(event);
        ssm.setEvent(action);


        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
            .when()
                .body(ssm)
                .post("/delete")
                .then();
    }
}