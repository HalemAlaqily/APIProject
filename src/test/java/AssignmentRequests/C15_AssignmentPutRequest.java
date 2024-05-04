package AssignmentRequests;
import base_urls.BaseUrlUser;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserContact;
import pojos.UserPojoRes;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C15_AssignmentPutRequest extends BaseUrlUser {
    @Test
    public void putRequest(){

        spec.pathParams("first", "users","second","me");
        UserContact expectedData  = new UserContact("Alma","Alaqily", "A123456","Alma@mail.com");
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();
        UserPojoRes actualData = response.as(UserPojoRes.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

    }
}
