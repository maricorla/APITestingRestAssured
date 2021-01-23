package tests;

import adapters.UsersAdapter;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
public class Chapter2Test extends BaseTest {


    String token;

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI="https://staging.earthoceandata.com/api";
}

    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {
        given().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void takePet(){
        given().
                when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").
                then().
                assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON);

    }

    @Test
    public void listOfPet(){
        given().
                //log().all().
                when().
                get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").
                then().body("[0].name", equalTo("fish"));
    }



   @Test(priority = 1)
    public void signUp(){

        Map<String,Object> userDetails = new HashMap<>();
        userDetails.put("firstName", "Marixa");
        userDetails.put("lastName","Gul");
        userDetails.put("email", "apimbnm@gmail.com");
        userDetails.put("password", "qwerty");
        userDetails.put("confirmPassword", "qwerty");
        userDetails.put("userType", 2);
        userDetails.put("acceptedPNP", true);
        userDetails.put("acceptedCC", true);

        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        request.header("accept-language","it");
        request.body(userDetails);

        Response response= request.post("/signup");
        response.then().log().ifValidationFails(LogDetail.BODY)
                .assertThat().statusCode(200)
                .assertThat().body("success", equals(true));

        String  responseBody = response.path("message").toString();
        Assert.assertEquals(responseBody, "La tua registrazione è stata completata con successo. Controlla la tua posta per attivare il tuo account");
        System.out.println(responseBody);
    }

   @Test(priority=2,description = "Login with good credentials")
    public void loginTest(){


      RequestSpecification request=RestAssured.given();

       request.header("Content-Type","application/json");
       request.header("accept-language","it");

        JSONObject requestParamBody= new JSONObject();
       requestParamBody.put("email","karinaqatest@gmail.com");
       requestParamBody.put("password","qwerty");
       requestParamBody.put("userType",2);
        request.body(requestParamBody.toJSONString());

        Response response= request.post("/login");

        response.then().log().ifValidationFails(LogDetail.BODY)
                .assertThat().statusCode(200)
        .assertThat().body("success", equalTo(true));

       token = response.path("token").toString();

        System.out.println(token);

    }

   @Test(priority=3, description = "testng check")
    public void getListOfCategories(){
        RequestSpecification request=RestAssured.given();
        request.header("Authorization", "Bearer "+token);
        request.header("Content-Type","application/json");
        request.header("accept-language","it");

        Response response= request.get("categories?page=1&limit=5");

        response.then().log().ifValidationFails(LogDetail.BODY)
                .assertThat().statusCode(200).
                assertThat().body("success", equalTo(true));


        ArrayList listOfData = response.path("data");

        System.out.println(listOfData);

       // Assert.assertEquals(listOfData.size(),5);
        Assert.assertTrue(listOfData.size()<=5);

    }


}*/
