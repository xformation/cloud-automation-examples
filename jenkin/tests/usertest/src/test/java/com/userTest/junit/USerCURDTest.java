package com.userTest.junit;

import com.user.Model.Autherity;
import com.user.Model.UserClass;
import com.userTest.cucumber.serenity.UserSerenitySteps;
import com.userTest.testbase.TestBase;
import com.userTest.utils.ReuseableSpecifications;
import com.userTest.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class USerCURDTest extends TestBase {
    static String username = "Sam" + TestUtils.getRandomValue();
    static String password = "password@111" + TestUtils.getRandomValue();
    static UserClass.Types type = UserClass.Types.CUSTOMER;
    static List<Autherity> roles;
    static String email = "sam@yahoo.co.in" + TestUtils.getRandomValue();
    static String id;

    @Steps
    UserSerenitySteps steps;

    @Title("This test will create a new User")
    @Test
    public void test001() {

        steps.createUser(username,password,email,type)
                .statusCode(201)
                .spec(ReuseableSpecifications.getGenericResponseSpec());
    }

   /* @Title("Verify  the User by ID")
    @Test
    public void test002() {
        HashMap<String,Object> value = (HashMap<String, Object>) steps.findUserByID(id);
        assertThat(value,hasValue(id));

        id = (String) value.get("id");
        steps.findUserByID(id);
        //HashMap<String, Object> value = steps.findUserByID(id);
        //assertThat(value, hasValue(username));
        //id = (String) value.get("id");

    }

   /* @Title("Update the service information and verify the updated information!")
    @Test
    public void test003() {
        username = username + "_Updated";
        steps.updateService(userID, username,email,password, type, roles );
        HashMap<String, Object> value = steps. getUserInfoByUserName(username);
        assertThat(value, hasValue(username));
    }

   /* @Title("Delete the service and verify if the student is deleted!")
    @Test
    public void test004() {
        steps.deleteUser(userID);
        steps.getuserById(userID).statusCode(404);
    }

    @Title("Delete and verify if the user is deleted!")
    @Test
    public void test003() {
        steps.deleteUser(username,email,password);
        steps.getuserById(userID).statusCode(404);
    }*/

    @Title("Update the user information and verify the updated information!")
    @Test
    public void test002(){


        username = username+"_Updated";
        steps.updateUser( username,email, password)
        //.getUserInfoById(id).statusCode(404)
        .spec(ReuseableSpecifications.getGenericResponseSpec());

        //HashMap<String,Object> value =  steps. getUserInfoById(id);
        //assertThat(value,hasValue(id));

    }

   /* @Title("Delete the User by Id and verify if the student is deleted!")
    @Test
    public void test004(){
        steps.deleteUserById();

    }*/

    @Title("Delete the User  and verify if the User is deleted!")
    @Test
    public void test003(){
        steps.deleteUser(id,username,email,password,type);

    }



    /*@Title("Get all Users by ID !")
    @Test
    public void test006(){
        steps.getUserInfoById();


    }
    @Title("Get User info by ID")
    @Test
    public void test006() throws JSONException, IOException, ParseException {
        steps.getUserByID(id);
    }*/

}



