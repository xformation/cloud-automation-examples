package com.servicetest.junit;

import com.service.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.servicetest.cucumber.serenity.ServiceSerenitySteps;
import com.servicetest.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@Concurrent(threads="4x")
@UseTestDataFrom("testdata/serviceinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateServicesDataDrivenTest extends TestBase {
	
	private String servicename;
	private String description;
	private String sla;

	public String getServiceName() {
		return servicename;
	}

	public void setServiceName(String servicename) {
		this.servicename = servicename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public ServiceSerenitySteps getSteps() {
		return steps;
	}

	public void setSteps(ServiceSerenitySteps steps) {
		this.steps = steps;
	}

	@Steps
	ServiceSerenitySteps steps;
	
	
	@Title("DataDriven Test for adding multiple services to the Service App.")
	@Test
	public void createMultipleServices(){
		Category category = new Category("Migration", Category.TYPE.SERVICE);
		steps.createService(servicename, description, sla, category)
		.statusCode(201);
	}
}
