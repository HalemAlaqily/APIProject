package AssignmentRequests;

import base_urls.BaseUrlPet;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStoreUser.StoreUserSetUp;
import utilities.ObjMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
public class C13_AssignmentpostRequest extends BaseUrlPet{
    @Test
    public void postRequest(){

 spec.pathParams("first", "v2", "second","user");

    String strJson = """
                {
                  "id": 1,
                  "username": "prisoner",
                  "firstName": "Rapunzel",
                  "lastName": "Princess Rapunzel of Corona",
                  "email": "Tangled@gmail.com",
                  "password": "Tangled2010",
                  "phone": "0519110480",
                  "userStatus": 0
                  }""";
    StoreUserSetUp expectedData = ObjMapperUtils.convertJsonToJava(strJson , StoreUserSetUp.class);
    System.out.println("expectedData = " + expectedData);

    Response response = given(spec).body(expectedData).post("{first}/{second}");
    response.prettyPrint();

    assertEquals(response.statusCode(),200);
    assertEquals(response.path("message"), "1");
    assertEquals(response.path("type"), "unknown");
                      }
}

