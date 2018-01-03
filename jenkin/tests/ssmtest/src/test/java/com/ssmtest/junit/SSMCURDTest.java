package com.ssmtest.junit;


import com.ssmtest.cucumber.serenity.SSMSerenitySteps;
import com.ssmtest.testbase.TestBase;
import com.ssmtest.utils.ReuseableSpecifications;
import com.ssmtest.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class SSMCURDTest extends TestBase {
    static String name = "Sam" + TestUtils.getRandomValue();
    static String target = "SSMTest1" + TestUtils.getRandomValue();
    static String event = "UpdateNode" + TestUtils.getRandomValue();
    static String action = "Update";
    static String id;
    @Steps
    SSMSerenitySteps steps;

    @Title("This test will create a new SSM")
    @Test
    public void test001() {

        steps.createSSM(name,target,event,action)
                .statusCode(201)
                .spec(ReuseableSpecifications.getGenericResponseSpec());
    }

    @Title("Update the SSM information and verify the updated information!")
    @Test
    public void test002(){


        name = name+"_Updated";
        steps.updateSSM( name,event, action)
                //.getUserInfoById(id).statusCode(404)
                .spec(ReuseableSpecifications.getGenericResponseSpec());

        //HashMap<String,Object> value =  steps. getUserInfoById(id);
        //assertThat(value,hasValue(id));

    }
    @Title("Delete the SSM  and verify if the SM is deleted!")
    @Test
    public void test003(){
        steps.deletessm(id,name,target,event,action);

    }


}
