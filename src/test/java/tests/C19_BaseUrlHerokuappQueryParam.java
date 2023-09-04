package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    @Test
    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
        yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek bir GET
        request gonderdigimizde, donen response’un status code’unun 200 oldugunu ve “Susan”
        ismine sahip en az 3 booking oldugunu test edin
         */


        // 1 - endpoint, req body

        specHerokuapp.pathParam("pp1", "booking").queryParam("firstname", "Susan");

        // 2 - expected data

        // 3 - req at, resp kaydet.

        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(3));
    }
}
