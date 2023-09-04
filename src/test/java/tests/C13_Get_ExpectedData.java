package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedData {
    @Test

    public void get01(){

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
        yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz

            Response body :
                {
                "userId": 3,
                "id": 22,
                "title": "dolor sint quo a velit explicabo quia nam",
                "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
                um mollitia molestiae aut atque rem suscipitnam impedit esse"
                }
        */

        // 1 - end point, req body

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2 - Expected data

        JSONObject expectedData = new JSONObject();

        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3 - req at resp kaydet

        Response response = given().when().get(url);

        // 4 - assertion

        /* junit classıyla assert yapmazsak

        response
                .then()
                .assertThat()
                .body("userId", equalTo(3),
                        "id", equalTo(22),
                        "title", equalTo("dolor sint quo a velit explicabo quia nam"),
                        "body", equalTo("eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear um mollitia molestiae aut atque rem suscipitnam impedit esse"));
        */

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("id"), responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"), responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"), responseJsonPath.get("body"));
        Assert.assertEquals(expectedData.get("userId"), responseJsonPath.get("userId"));


    }
}
