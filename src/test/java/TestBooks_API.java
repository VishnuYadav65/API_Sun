import com.opencsv.exceptions.CsvValidationException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestBooks_API {
    String baseURL = "https://simple-books-api.glitch.me";
    public static String token;
//    String name = "Postman";
//    String email = "valentin\"+Math.random()+\"@example.com";
    @Test
    public void authorization() throws CsvValidationException, IOException {

        Reusablecomponents reusable = new Reusablecomponents();
        List data = reusable.getData();


        RestAssured.baseURI = baseURL;
        for (Object d : data) {

            Response AuthroziationResponse = given().log().all()
                    .contentType(ContentType.JSON).body(d).
                    when().post("/api-clients").
                    then().log().all().assertThat().statusCode(201).extract().response();

            JsonPath js = new JsonPath(AuthroziationResponse.asString());
            token = js.getString("acessToken");
        }
    }
}