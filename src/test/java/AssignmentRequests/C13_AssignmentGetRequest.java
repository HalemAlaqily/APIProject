package AssignmentRequests;
import base_urls.BaseUrlPet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStoreUser.StoreUserSetUp;
import utilities.ObjMapperUtils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class C13_AssignmentGetRequest extends BaseUrlPet {
    @Test
    void getRequest(){
        spec.pathParams("first", "v2", "second","user","third","prisoner");

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
        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();


}
}
