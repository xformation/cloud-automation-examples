package com.servicetest.cucumber.serenity;

import com.service.model.Category;
import com.service.model.ServiceClass;
import com.servicetest.utils.ReuseableSpecifications;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ServiceSerenitySteps {

    @Step("Creating Service with ServiceName:{0}, description:{1}, sla:{2}")
    public ValidatableResponse createService(String ServiceName, String description, String sla, Category category) {
        ServiceClass service = new ServiceClass();
        service.setName(ServiceName);
        service.setDescription(description);
        service.setSLA(sla);
        service.setCategory(category);
        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(service)
                .post("/create")
                .then();
    }

    /*@Step("Getting the student information with firstName: {0}")
    public HashMap<String, Object> getServiceInfoByServiceName(String ServiceName) {
        String p1 = "findAll{it.ServiceName=='";
        String p2 = "'}.get(0)";

        return SerenityRest.rest().given()
                .when()
                .get("/listAll")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path(p1 + ServiceName + p2);
    }*/

    @Step("Updating Service information with ServiceName: {0} , description:{1}, sla:{2}")
    public ValidatableResponse updateService( String ServiceName,
                                             String description, String sla) {

        Category category = new Category("Migration", Category.TYPE.SERVICE);
        ServiceClass service = new ServiceClass();
        service.setName(ServiceName);
        service.setDescription(description);
        service.setSLA(sla);
        service.setCategory(category);


        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec()).log().all()
                .when().body(service).put("/update").then();
    }

   /* @Step("Deleting student information with ID: {0}")
    public void deleteService(String serviceId) {
        SerenityRest.rest().given().when().delete("/" + serviceId);
    }


    @Step("Getting information of the student with ID: {0}")
    public ValidatableResponse getServiceById(String serviceId) {
        return
                SerenityRest
                        .rest()
                        .given()
                        .when()
                        .get("/" + serviceId).then();

    }*/

    @Step("Deleting Service with Id:{0},ServiceName:{1}, Category:{2}, Description:{3}, SLA:{4}")
    public ValidatableResponse deleteUser(String id, String servicename, String description, String sla) {
        ServiceClass service = new ServiceClass();
        /*username=user.getUsername();
        email=user.getEmail();
        password=user.getPassword();*/
       service.setId(id);
       service.setDescription(description);
       service.setName(servicename);
       service.setSLA(sla);


        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(service)
                .post("/delete")
                .then();
    }


}
