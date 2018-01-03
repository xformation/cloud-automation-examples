package com.ssmtest.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://192.168.1.58:8083/api/v1/states";
    }
}