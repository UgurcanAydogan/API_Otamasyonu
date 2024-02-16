import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_Get_BodyTekrarlardanKurtulma {

    /*
        https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json, ve response body'sindeki
        "firstname"in, "Eric",
        ve "lastname"in, "Wilson",
        ve "totalprice"in, 866,
        ve "depositpaid"in, true,
        ve "additionalneeds"in, "Breakfast" oldugunu test edin


       NOT : Veriler değişiyor Postman'de dataları kontrol ediniz
 */


    @Test
    public void bodyTekrarindanKurtulma() {

        //  1-Endpoint belirlenerek hazırlanır
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //  2-Gerekli ise Expected Data hazırlanır

        //  3-Actual Data kaydedilir
        Response response = given().when().get(url);

        //  4-Assertion İşlemi Yapılır
        response.then().assertThat()
                                    .statusCode(200)
                                    .contentType("application/json")
                                    .body("firstname", equalTo("Eric"),
                                     "lastname", equalTo("Wilson"),
                                            "totalprice", equalTo(866),
                                            "depositpaid", equalTo(true),
                                            "additionalneeds",equalTo("Breakfast"));

        System.out.println(response.contentType());

       }




  }


