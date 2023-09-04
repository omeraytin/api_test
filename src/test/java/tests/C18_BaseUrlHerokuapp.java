package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Reporter;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    @Test

    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking
        endpointine yandaki body’ye sahip bir POST request
        gonderdigimizde donen response’un status code’unun
        200 oldugunu ve “firstname” degerinin “Ali”
        oldugunu test edin

           {
            "firstname" : "Ali",
            "lastname" : “Kara",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
            "checkin" : "2023-06-01",
            "checkout" : "2023-06-10"
            },
            "additionalneeds" : "wi-fi"
           }

         */


        // 1 - endpoint, req body

        specHerokuapp.pathParam("pp1", "booking");

        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleriJson = new JSONObject();

        rezervasyonTarihleriJson.put("checkin", "2023-06-01");
        rezervasyonTarihleriJson.put("checkout", "2023-06-10");

        requestBody.put("firstname", "Ali");
        requestBody.put("lastname", "Kara");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("additionalneeds", "wi-fi");
        requestBody.put("bookingdates", rezervasyonTarihleriJson);

        // 2 - Expected data

        // 3 - req at resp kaydet

        Response response = given().contentType(ContentType.JSON)
                            .when().spec(specHerokuapp).body(requestBody.toString())
                            .post("/{pp1}");

        // 4 - assertion

        response
                .then()
                .assertThat()
                .statusCode(200);

    }
}
