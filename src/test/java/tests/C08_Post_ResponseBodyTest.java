package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTest {
    @Test

    public void test01(){

        /*
                        https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
                gonderdigimizde

                {
                "title":"API",
                "body":"good to learn API test",
                "userId":10,
                }

                donen Response’un,
                status code’unun 201,
                ve content type’inin application/json
                ve Response Body'sindeki,
                "title"'in "API" oldugunu
                "userId" degerinin 100'den kucuk oldugunu
                "body" nin "API" kelimesi icerdigini
                test edin.

         */

        // 1 - endpoint, req body

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();

        requestBody.put("title", "API");
        requestBody.put("body", "good to learn API test");
        requestBody.put("userId", 10);


        // 2 - Expected data

        // 3 - req at resp kaydet.

        Response response = given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString())
                            .post(url);

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId", Matchers.lessThan(100))
                .body("body", Matchers.containsString("API"));


    }
}
