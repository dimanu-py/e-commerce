package dimanu.app.backoffice.healthcheck;

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
class HealthCheckGetControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void should_check_application_health() {
        int expectedStatusCode = 200;
        String expectedBody = "{\"status\":\"Healthy\"}";

        Response response = whenARequestIsMadeTo("/health-check");

        thenResponseShouldSatisfy(
                expectedStatusCode,
                expectedBody,
                response
        );
    }

    private Response whenARequestIsMadeTo(String endpoint) {
        return given().get(endpoint);
    }

    private void thenResponseShouldSatisfy(int expectedStatusCode, String expectedBody, Response response) {
        response
                .then()
                .statusCode(expectedStatusCode)
                .contentType(ContentType.JSON)
                .body(equalTo(expectedBody));
    }

}