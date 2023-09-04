package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlJsonPlaceholder extends BaseUrlJsonPlaceholder {

        /*
        https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
        edin
         */

        @Test
        public void test01(){

            // 1 - endpoint

            specJsonPlaceholder.pathParam("pp1", "posts");

            // 2 - expected data

            // 3 - req at resp kaydet

            Response response = given()
                                .when().spec(specJsonPlaceholder)
                                .get("/{pp1}");



            // 4 - Assertion

            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("title", Matchers.hasSize(100));

        }

        @Test
        public void test02(){

            /*
            https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
            donen response’un status code’unun 200 oldugunu ve “title” degerinin
            “optio dolor molestias sit” oldugunu test edin.
             */


            // 1 - endpoint

            specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 44);

            // 2 - expected data

            // 3 - req at resp kaydet

            Response response = given()
                                .when().spec(specJsonPlaceholder)
                                .get("/{pp1}/{pp2}");

          response
                  .then()
                  .assertThat()
                  .statusCode(200)
                  .body("title", Matchers.equalTo("optio dolor molestias sit"));

        }


}
