package com.userTest.junit;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;

import static net.serenitybdd.rest.RestRequests.when;

public class RestAssuredTest {
    public static Response response;
    public static String jsonAsString;

    @BeforeClass
    public static void setURL()
    {
        RestAssured.baseURI = "http://192.168.1.58:8080/api/v1/users/";

    }
    @BeforeClass
    public static void getJsonResponseString()
    {
        // call the rides API, the full address is "http://yourwebsiteaddress.com/api/yourapi/rides",
        // but we set the default above, so just need "/rides"
        response =
                when().
                        get("/").
                        then().
                        contentType(ContentType.JSON).  // check that the content type return from the API is JSON
                        extract().response(); // extract the response

        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
        jsonAsString = response.asString();
        System.out.println(jsonAsString);
    }
}
