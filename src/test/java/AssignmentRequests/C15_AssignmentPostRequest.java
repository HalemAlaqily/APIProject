package AssignmentRequests;
import base_urls.BaseUrlUser;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserContact;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ObjMapperUtils.convertJsonToJava;

public class C15_AssignmentPostRequest extends BaseUrlUser {
//        "user": {
//        "_id": "663669820a93760013f0d176",
//                "firstName": "Halima",
//                "lastName": "Alaqily",
//                "email": "halema@l.com",
//                "__v": 1
    @Test
    public void postRequest(){

        spec.pathParams("first", "users");

        //Set the expected data
        String strJson = """
                {
                    "firstName": "Halima",
                    "lastName": "Alaqily",
                    "email": "halema@n.com",
                    "password": "h123456"
                                                     }
                    """;

        UserContact expectedData = convertJsonToJava(strJson, UserContact.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        UserContact actualData = convertJsonToJava(response.asString(), UserContact.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
    }
}
