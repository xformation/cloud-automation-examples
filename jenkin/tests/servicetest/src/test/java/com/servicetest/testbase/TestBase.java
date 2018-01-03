package com.servicetest.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://192.168.1.58:8080/api/v1/service";
	}
}
