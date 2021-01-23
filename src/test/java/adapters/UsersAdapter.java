package adapters;

import adapters.MainAdapter;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.LoginUser;
import models.User;
import models.UserLogged;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class UsersAdapter extends MainAdapter {

    String token;


   /* @BeforeClass
    public void setUp(){
        RestAssured.baseURI="https://staging.earthoceandata.com/api";
    }*/

    public boolean signUp(User user){
        Response response =
                given()
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .header("accept-language","it")
                        .body(gson.toJson(user))
                        .when()
                        .post("/signup")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON).extract().response();
        boolean isUserCreated = response.path("success");


        return isUserCreated ;

    }

    public UserLogged loginUser(LoginUser loginUser){
        Response response =
                given()
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .header("accept-language","it")
                        .body(gson.toJson(loginUser)).post("https://staging.earthoceandata.com/api/login")
                        .then()
                        .log().ifValidationFails(LogDetail.BODY)
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON).extract().response();

                     return gson.fromJson(response.asString().trim(),UserLogged.class);

    }

}
