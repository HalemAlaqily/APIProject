package AssignmentRequests;

import base_urls.BaseUrlPet;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStoreUser.StoreUserSetUp;
import utilities.ObjMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
public class C13_AssignmentPutRequest extends BaseUrlPet {
    @Test
    public void postRequest(){

        spec.pathParams("first", "v2", "second","user","third","prisoner");
        String strJson = """
                {
                  "id": 1911048,
                  "username": "prisoner",
                  "firstName": "coli",
                  "lastName": "Princess Rapunzel of Corona",
                  "email": "Tangled@gmail.com",
                  "password": "Tangled2010",
                  "phone": "0519110480",
                  "userStatus": 9
                  }""";
        StoreUserSetUp expectedData = ObjMapperUtils.convertJsonToJava(strJson , StoreUserSetUp.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}/{third}");
        response.prettyPrint();
        //Do assertion
        assertEquals(response.statusCode(),200);
        assertEquals(response.path("message"), "19");
        assertEquals(response.path("type"), "unknown");
    }

}
