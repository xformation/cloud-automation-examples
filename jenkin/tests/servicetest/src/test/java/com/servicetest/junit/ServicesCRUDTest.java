package com.servicetest.junit;

import com.service.model.Category;
import com.servicetest.cucumber.serenity.ServiceSerenitySteps;
import com.servicetest.testbase.TestBase;
import com.servicetest.utils.ReuseableSpecifications;
import com.servicetest.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicesCRUDTest extends TestBase {

    static String ServiceName = "SMOKESERVICE" + TestUtils.getRandomValue();
    static String description = "SMOKESERVICEDESC" + TestUtils.getRandomValue();
    static String sla = TestUtils.getRandomValue();
    static String serviceId;

    @Steps
    ServiceSerenitySteps steps;

    @Title("This test will create a new student")
    @Test
    public void test001() {
        Category category = new Category("Migration", Category.TYPE.SERVICE);
        steps.createService(ServiceName, description, sla, category)
                .statusCode(201)
                .spec(ReuseableSpecifications.getGenericResponseSpec());
    }

   /* @Title("Verify if the student was added to the application")
    @Test
    public void test002() {

        HashMap<String, Object> value = steps.getServiceInfoByServiceName(ServiceName);
        assertThat(value, hasValue(ServiceName));
        serviceId = (String) value.get("id");

    }*/

    @Title("Update the service information and verify the updated information!")
    @Test
    public void test002() {
        ServiceName = ServiceName + "_Updated";
        steps.updateService( ServiceName, description, sla)
        //HashMap<String, Object> value = steps.getServiceInfoByServiceName(ServiceName);
        //assertThat(value, hasValue(ServiceName));
        .spec(ReuseableSpecifications.getGenericResponseSpec());
    }

    @Title("Delete the service and verify if the student is deleted!")
    @Test
    public void test003() {
        steps.deleteUser(serviceId,ServiceName,description,sla);

    }
}
