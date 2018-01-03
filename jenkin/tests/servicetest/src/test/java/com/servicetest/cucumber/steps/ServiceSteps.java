package com.servicetest.cucumber.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.service.model.Category;
import com.servicetest.cucumber.serenity.ServiceSerenitySteps;
import com.servicetest.utils.TestUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class ServiceSteps {
	@Steps
	ServiceSerenitySteps steps;
	
	static String servicename=null;
	
	@When("^User sends a GET request to list, then the application must provide a valid response$")
	public void user_sends_a_GET_request_to_list_then_the_application_must_provide_a_valid_response() throws Throwable {
	  
		SerenityRest.rest().given()
		.when()
		.get("/listAll")
		.then();
	 
	}
	

	@When("^I create a new student by providing the information ServiceName (.*) Category (.*) description (.*) sla (.*) $")
	public void createService(String ServiceName,String description, String sla,Category category){
		System.out.println("The service name is "+ServiceName);
		steps.createService(ServiceName, description, sla, category)
		.statusCode(201);
	}
	
	/*@Then("^I verify that the service with (.*) is created$")
	public void i_verify_that_the_service_with_servicename_is_created(String servicename){
		HashMap<String, Object> resVal=  steps.getServiceInfoByServiceName(servicename);
		System.out.println("The values are : "+resVal);
		//assertThat(resVal,hasValue(emailId));
	}*/
}
