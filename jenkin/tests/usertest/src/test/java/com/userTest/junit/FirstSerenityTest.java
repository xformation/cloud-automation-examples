package com.userTest.junit;

import com.user.Model.Autherity;
import com.user.Model.UserClass;
import com.userTest.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Array;
import java.util.List;

import static net.serenitybdd.rest.RestRequests.post;
import static net.serenitybdd.rest.RestRequests.when;
import static net.serenitybdd.rest.SerenityRest.expect;


@RunWith(SerenityRunner.class)
    public class FirstSerenityTest {
    static String username = "Sam" + TestUtils.getRandomValue();
    static String password = "password@111" + TestUtils.getRandomValue();
    static UserClass.Types type = UserClass.Types.CUSTOMER;
    static List<Autherity> roles;
    static String email = "sam@yahoo.co.in" + TestUtils.getRandomValue();
    static String userID;
    public static Response response;
    public static String jsonAsString;

        @BeforeClass
        public static void init() {
            RestAssured.baseURI = "http://192.168.1.58:8080/api/v1/users/";
        }

        @Test
        public void getAllUsers() {
            SerenityRest.given()
                    .when()
                    .get("/listAll")
                    .then()
                    .statusCode(201);
        }
        @Test
        public  void getJsonResponseString()
        {
            // call the rides API, the full address is "http://yourwebsiteaddress.com/api/yourapi/rides",
            // but we set the default above, so just need "/rides"
            response =
                    when().
                            get("/listAll").
                            then().
                            contentType(ContentType.JSON).  // check that the content type return from the API is JSON
                            extract().response(); // extract the response

            // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
            jsonAsString = response.asString();
            System.out.println(jsonAsString);
           // String name_value = post("http://192.168.1.58:8080/api/v1/users/").path("id");
            //System.out.println(name_value);
            try {
                JSONArray jArray = (JSONArray) new JSONTokener(jsonAsString).nextValue();
                //System.out.println(jArray.get(3));
                System.out.println(jArray.length());
                System.out.println(jArray.toString(3));
                //JSONObject obj=jArray.getJSONObject(4);
                //JSONObject obj2=obj.getJSONObject("id");
                //String id=obj2.getString("id");
                //Integer id = obj2.getInt("id");
                //String id = obj2.getString("id");
                 // System.out.println(id);
                //JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonAsString);
               // System.out.println(jsonObject.toString(4));
                /*for(int i=0;i<jArray.length();i++)
                {
                   if(jArray[i][username]== "Sam")
                   {

                   }
                }

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonAsString);
                String id = (String) jsonObject.get("id");
                System.out.println("The first name is: " + id);
                */





            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
       /* @Test
        public void createUser()
        {
            SerenityRest.given()
                    .when()
                    .get("/create")
                    .then()
                    .statusCode(201);
        }

        @Test
        public void deleteUser()
        {
            SerenityRest.given()
                    .when()
                    .get("/delete")
                    .then()
                    .statusCode(201);
        }

        @Test
    public void updateUser()
        {
            SerenityRest.given()
                    .when()
                    .get("/update")
                    .then()
                    .statusCode(201);
        }*/

    /* @Test
     public void findUserByID()
    {
        //Object Sam77643;
        String locationHeader = SerenityRest.given()
                        .contentType("application/json; charset=UTF-8").
                        body("{ "username": "Mahadi Hasan", "email": "test...@gmail.com"}").
                       // .body("{ "username": "Sam77643", "email": "sam@yahoo.co.in52121"}").
                        expect()
                        . log().ifValidationFails().statusCode(201)
                        .when()
                        .post("/")
                        
                        .header("Location");

        String userId = StringUtils.substringAfter(locationHeader, "/listAll");
        System.out.println(userId);
    }

    /*@Test
    public void deleteUser() {
        SerenityRest.given()
                .when()
                .get("/delete")
                .then()
                .statusCode(201);
    }*/


        /*@Test
        public void thisIsaFailing() {
            SerenityRest.given()
                    .when()
                    .get("/listAll")
                    .then()
                    .statusCode(500);
        }

        @Pending
        @Test
        public void thisIsAPendingTest() {

        }*/
    }

