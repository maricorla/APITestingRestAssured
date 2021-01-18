package Examples;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;

public class Chapter2Test {

    String baseUrl="https://staging.earthoceandata.com/api/";
    String token;

  /*  @Test
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
    }*/

    @Test(priority=1)
    public void loginTest(){

        RestAssured.baseURI=baseUrl;
      RequestSpecification request=RestAssured.given();

        JSONObject requestParam= new JSONObject();
        requestParam.put("email","karinaqatest@gmail.com");
        requestParam.put("password","qwerty");
        requestParam.put("userType",2);
       request.header("Content-Type","application/json");
       request.header("accept-language","it");
        request.body(requestParam.toJSONString());

        Response response= request.post("login");

        response.then().log().ifValidationFails(LogDetail.BODY)
                .assertThat().statusCode(200)
        .assertThat().body("success", equalTo(true));

        token = response.path("token").toString();

        System.out.println(token);

    }

    @Test(priority=2)
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


}
