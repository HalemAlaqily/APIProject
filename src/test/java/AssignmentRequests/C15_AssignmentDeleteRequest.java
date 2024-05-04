package AssignmentRequests;
import base_urls.BaseUrlUser;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserContact;
import pojos.UserPojoRes;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class C15_AssignmentDeleteRequest extends BaseUrlUser {
    @Test
    void updateBookingTest() {
        spec.pathParams("first", "users", "second", "me");

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertTrue(response.asString().isEmpty());
}}
