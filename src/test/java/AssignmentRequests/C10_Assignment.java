package AssignmentRequests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class C10_Assignment extends JsonPlaceHolderBaseUrl {
    @Test
    public void testAvailablePet() {
        //Set the Url
        spec.pathParams("first", "v2", "second", "pet", "third",
                "findByStatus").queryParams("status", "available");

        Response response = given(spec).get("{first}/{second}/{third}");

        response.prettyPrint();

        //assert
        response.then().body("", hasSize(greaterThan(100)));
    }
}