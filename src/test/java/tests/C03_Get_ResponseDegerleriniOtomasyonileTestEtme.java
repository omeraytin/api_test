package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonileTestEtme {

    @Test

    public void test02(){

        // 1 -  endpoint req body

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 - expected body.

        // 3 - req at resp kaydet

        Response response = given().when().get(url);

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }
}
