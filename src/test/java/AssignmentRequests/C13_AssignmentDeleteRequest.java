package AssignmentRequests;
import base_urls.BaseUrlPet;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C13_AssignmentDeleteRequest extends BaseUrlPet{
    @Test
    public void deleteRequest(){
    spec.pathParams("first", "user", "second","user","third","prisoner");
        Response response = given(spec).delete("{first}/{second}/{third}");




}}
