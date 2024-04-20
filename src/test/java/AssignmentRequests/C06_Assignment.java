package AssignmentRequests;
import AssignmentRequests.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class C06_Assignment extends BaseTest{
//     1) https://reqres.in/api/users
//            2) {
//        "name": "morpheus",
//                "job": "leader"
//    }
//    I send POST Request to the Url
//    Status code is 201
//    And response body should be like {
//        "name": "morpheus",
//                "job": "leader",
//                "id": "496",
//                "createdAt": "2022-10-04T15:18:56.372Z"
//    }
@Test
public void postRequestTest() {

    //Set the Url
    spec.pathParams("first", "");

    //Set the expected data(Payload) --> Preparing expected data as String is not recommended. Because we can not extract specific field from String body for assertion.
    String expectedData = """
                                    {
                                    "name": "morpheus",
                                            "job": "leader"}
                                            """;

    //Send the request and get the response
    Response response = given(spec)
            //.contentType(ContentType.JSON)//For serialization we need to declare content type. This process is repetitive action, to avoid repeation we will put this in spec object.
            .body(expectedData)
            .post("{first}");

    response.prettyPrint();

    //Do assertion
    response
            .then()
            .statusCode(201)
            .body("name", equalTo("morpheus"),
                    "job", equalTo("leader"));

}


}
