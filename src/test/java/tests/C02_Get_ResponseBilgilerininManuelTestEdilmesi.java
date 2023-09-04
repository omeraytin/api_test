package tests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgilerininManuelTestEdilmesi {

    @Test

    public void test01(){

         /*endpointten donen response icin status code, content type, headerlar,
         respnse suresi 5snden kucuk mu vs. test et.*/

        // 1 - gerekli endpoint ve body.

        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2 - expected resp body.

        //3 - req at doneni resp kaydet

        Response response = given().when().get(url);

        response.prettyPrint(); //prettyPrint ile sadece body yazdirma.

        System.out.println("Status code :" +response.getStatusCode()+
                           "\nContent type :" +response.getContentType()+
                           "\nServer header value :" +response.getHeader("Server")+
                           "\nStatus line value :" +response.getStatusLine()+
                           "\nResponse time :" +response.getTime());

    }
}
