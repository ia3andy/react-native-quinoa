package org.acme;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BeerResourceTest {

    @TestHTTPResource("/api/beers/types")
    URL beersTypes;

    @Test
    public void testBeersTypesEndpoint() {
        given()
                .when().get(beersTypes)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", is(20));
    }

}