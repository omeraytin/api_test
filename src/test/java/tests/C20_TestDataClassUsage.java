package tests;

import TestDatas.TestDataDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_TestDataClassUsage extends BaseUrlDummyExample {
    @Test
    public void test01(){


        // 1 - endpoint

        specDummyExample.pathParams("pp1","employee", "pp2", "3");

        // 2 - expected data

        JSONObject expectedData = TestDataDummyExample.jsonResponseBodyOlustur(3,"Ashton Cox",86000,66,"");

        // 3 - req at resp kaydet

        Response response = given().spec(specDummyExample).when().get("{pp1}/{pp2}");


        // 4 - Assertion

        JsonPath responseJP = response.jsonPath();

        // status code 200
        assertEquals(TestDataDummyExample.basariliSorguStatusCode, response.statusCode());

        //content type
        assertEquals(TestDataDummyExample.contentType, response.contentType());

        //body - response match
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"), responseJP.getString("data.profile_image"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"), responseJP.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"), responseJP.getInt("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getInt("id"), responseJP.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"), responseJP.getInt("data.employee_age"));

        assertEquals(expectedData.getString("message"), responseJP.getString("message"));
        assertEquals(expectedData.getString("status"), responseJP.getString("status"));
    }
}
