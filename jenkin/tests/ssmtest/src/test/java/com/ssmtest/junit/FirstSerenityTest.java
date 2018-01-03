package com.ssmtest.junit;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
   static String name = "Dsaha-State1.12";
    static String event = "createNode";
    static String action = "create";
    static String id;

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://192.168.1.58:8083/api/v1/states/";
    }

    @Test
    public void getAllStates() {
        SerenityRest.given()
                .when()
                .get("/listAll")
                .then()
                .statusCode(201);
    }




}
