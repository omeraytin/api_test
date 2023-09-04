package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_TestYaparkenTekrarlardanKurtulma {

    @Test

    public void test01(){

        /*
                        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
                donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                "firstname“in, "Susan",
                ve "lastname“in, "Jackson",
                ve "totalprice“in, 1000'den kucuk oldugu,
                ve "depositpaid“in, false,
                ve "additionalneeds“ not null
                oldugunu test edin
         */

        // 1 - endpoint, request body

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 - expected data.

        // 3 - req at resp save

        Response response = given().when().get(url);

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds",notNullValue());
    }
}