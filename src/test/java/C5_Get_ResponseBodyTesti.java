import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.regex.Matcher;  // import java.util.regex.Matcher.*; --> yaparsak (Matcher) yazmamıza gerek kalmaz.

import static io.restassured.RestAssured.given;

public class C5_Get_ResponseBodyTesti {

    //   https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
    //   donen Response'in
    //   status code'unun 200,
    //   ve content type'inin application/json; charset=utf-8,
    //   ve response body'sinde bulunan userId'nin 5,
    //   ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.

    @Test
    public void responseBodyTesti(){

        //  1-Endpoint belirlenerek hazırlanır
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        //  2-Soruda verilmişse expected data hazirlanir.

        //  3-Actual Data kaydedilir
        Response response = given().when().get(url);

        response.prettyPrint(); // çok tercih edilen değil büyük projelerde sorun çıkarır.

        //  4-Assertion İşlemi Yapılır
        response.then().assertThat()
                                    .statusCode(200)
                                    .contentType("application/json; charset=utf-8")
                                    .body("userId", Matchers.equalTo(5))
                                    .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
}
