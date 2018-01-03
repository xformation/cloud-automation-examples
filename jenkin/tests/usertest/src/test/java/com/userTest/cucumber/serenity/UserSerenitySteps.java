package com.userTest.cucumber.serenity;

import com.user.Model.UserClass;
import com.userTest.utils.ReuseableSpecifications;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;

public class UserSerenitySteps {


    @Step("Creating User with UserName:{0}, email:{1}, password:{2}")
    public ValidatableResponse createUser(String username, String password, String email, UserClass.Types type) {
        UserClass user = new UserClass();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setType(type);


        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(user)
                .post("/create")
                .then();
    }

   /* @Step("Getting the User information with firstName: {0}")
    public HashMap<String, Object> getUserInfoByUserName(String username) {
        String p1 = "findAll{it.username=='";
        String p2 = "'}.get(0)";

        return SerenityRest.rest().given()
                .when()
                .get("/listAll")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path(p1 + username + p2);
    }

    /*@Step("Updating User information with UserID: {0} username:{1}, email:{2}, password:{3}")
    public ValidatableResponse updateService(String userid, String username,
                                             String email, String password, UserClass.Types type,List<Autherity> roles ) {


       UserClass user = new UserClass();
        user.setUsername(username);
        user.setRoles(roles);
        user.setType(type);
        user.setPassword(password);
        user.setEmail(email);


        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec()).log().all()
                .when().body(user).put("/" + userid).then();
    }

    @Step("Deleting student information username:{0}, email:{1}, password:{2}")
    public ValidatableResponse deleteUser(String username,String email,String password) {
        UserClass user = new UserClass();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec()).log().all()
                .when().body(user).post("/delete" ).then();
    }


    @Step("Getting information of the student with ID: {0}")
    public ValidatableResponse findUserByID(String userId) {
                UserClass user=new UserClass();
        return
        SerenityRest.rest().given().when().get("http://192.168.1.58:8080/api/v1/users/{id}", user.getId()).then();

    }*/

    @Step("Updating User information with  firstName:{0}, email:{1}, password:{2}")
    public ValidatableResponse updateUser(String username, String email, String password) {

        UserClass user = new UserClass();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        /*return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec()).log().all()
                .when().body(user).post("/update" ).then();*/
        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(user)
                .post("/update")
                .then();
    }

    /*@Step("Deleting student information with ID: {0}")
    public void deleteUserById() {
        UserClass user=new UserClass();
        SerenityRest.rest().given().when().delete("/delete/" + user.getId());
    }*/

   /* @Step("Getting the User information with id: {0}")
    public ValidatableResponse getUserInfoById(String id) {

        UserClass user = new UserClass();
        String id=SerenityRest.rest().given()
                .contentType("application/json").body(user).when().
                        post("/").
                        then().
                        statusCode(200).
                        extract().
                        path("id");
        Response response = expect().statusCode(200).given().body(requestBody).contentType("application/json")
                .when().post("/");
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
         String id = jsonPath.getString("id");
        return
                SerenityRest.rest().given()
                .when()
                .get("/" + id)
                .then();
                }*/




    @Step("Deleting User with Id:{0},UserName:{1}, email:{2}, password:{3}, type:{4}")
    public ValidatableResponse deleteUser(String id, String username, String email, String password, UserClass.Types type) {
        UserClass user = new UserClass();
        /*username=user.getUsername();
        email=user.getEmail();
        password=user.getPassword();*/
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setType(type);


        return SerenityRest.rest().given()
                .spec(ReuseableSpecifications.getGenericRequestSpec())
                .when()
                .body(user)
                .post("/delete")
                .then();
    }


   /* @Step("Getting the User information with id: {0}")
    public ValidatableResponse getUserByID(String id)  {
        //RestAssured.baseURI = "http://192.168.1.58:8080//api/v1/users/";
        //RequestSpecification httpRequest = RestAssured.given();
        //Response response = httpRequest.get("/");

        // Retrieve the body of the Response
        //ResponseBody body = response.getBody();

        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        //String bodyAsString = body.asString();

        // convert the body into lower case and then do a comparison to ignore casing.
        //Assert.assertEquals(String.valueOf(bodyAsString.toLowerCase().contains("Sam")) /*Expected value*///, true /*Actual Value*/, "Response body contains Sam");

        //JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        //String id = jsonPathEvaluator.get("id");

        // Let us print the city variable to see what we got
        //System.out.println("id received from Response " + id);

        // Validate the response
        //Assert.assertEquals(id, bodyAsString.toLowerCase().contains("Sam"));

        /*JSONArray results = getbodyPage.getJSONArray(Integer.parseInt("results"));
        JSONObject first = results.getJSONObject(0);
        String id = first.getString("id"); // Get id of the found page
        System.out.println("INFO : Found ID - " + id);
        System.out.println("INFO : Found ID - " + id);
        //JSONObject jsonObject = jsonReader.readObject();
        //JsonParser jsonParser = Json.createParser(fis);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        // get a String from the JSON object
         id = (String) jsonObject.get("id");
        System.out.println("The first name is: " + id);



        return
                SerenityRest.rest().given()
                        .when()
                        .get("/" + id)
                        .then();

    }*/



}



