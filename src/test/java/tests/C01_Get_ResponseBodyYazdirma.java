package tests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class C01_Get_ResponseBodyYazdirma {

    @Test

    public void get01(){

        // 1 - request body, endpoint
        // https://restful-booker.herokuapp.com/booking/10

        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2 - expected data

        // 3 - response kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();
        // 4 - assertion
    }


}
