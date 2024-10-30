import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITests {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testCreatingPet() {

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 286,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"Yason\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"sold\"\n" +
                        "}")
                .log().all()
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void testUpdatingPet() {

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 286,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"Yason(Updated)\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"sold\"\n" +
                        "}")
                .log().all()
                .when()
                .put("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void testDeletingPet() {
        given()
                .log().all()
                .when()
                .delete("/pet/286")
                .then()
                .log().all()
                .statusCode(200);
    }
}
