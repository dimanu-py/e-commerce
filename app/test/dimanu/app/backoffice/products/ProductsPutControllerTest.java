package dimanu.app.backoffice.products;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductsPutControllerTest {

    private static final String NO_BODY = "";
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void should_create_a_valid_product() {
        int expectedStatusCode = 201;
        String requestBody = "{\"name\":\"anyName\",\"description\":\"anyDescription\",\"price\":100.0,\"stock\":10}";

        Response response = whenARequestIsMadeTo(
                "/products/46272940-0b50-4e2c-be41-426ea4373472",
                requestBody
        );

        thenResponseShouldSatisfy(
                expectedStatusCode,
                NO_BODY,
                response
        );
    }

    private Response whenARequestIsMadeTo(String endpoint, String requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(endpoint);
    }

    private void thenResponseShouldSatisfy(int expectedStatusCode, String expectedBody, Response response) {
        response
                .then()
                .statusCode(expectedStatusCode)
                .body(equalTo(expectedBody));
    }
}