package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathUsage {

    @Test

    public void method01(){

        JSONObject kisiBilgisi = new JSONObject();

        JSONObject adresBilgisi =new JSONObject();

        JSONArray telBilgileri = new JSONArray();
            JSONObject cepTelefonu =new JSONObject();
            JSONObject evTel = new JSONObject();

        cepTelefonu.put("type","Cep Telefonu");
        cepTelefonu.put("number", "555-123-4567");
        evTel.put("type","Ev telefonu");
        evTel.put("number","312-123-4567");
        telBilgileri.put(cepTelefonu);
        telBilgileri.put(evTel);

        adresBilgisi.put("streetAddress", "Yenimahalle kurtulus cad");
        adresBilgisi.put("city","Ankara");
        adresBilgisi.put("postalCode","06100");

        kisiBilgisi.put("firstName","Ahmet");
        kisiBilgisi.put("lastName","Bulut");
        kisiBilgisi.put("age",49);
        kisiBilgisi.put("address",adresBilgisi);
        kisiBilgisi.put("phoneNumbers",telBilgileri);

        System.out.println(kisiBilgisi);



        /* JSON pathsiz cok ugrastirir. bunun yerine -> phoneNumbers[0].number

        System.out.println("\nTel no : " +
                kisiBilgisi
                        .getJSONArray("phoneNumbers")
                        .getJSONObject(0)
                        .get("number"));
         */


    }
}
