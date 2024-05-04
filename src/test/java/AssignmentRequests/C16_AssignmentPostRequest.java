package AssignmentRequests;
import base_urls.BaseUrlUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserContact;
import utilities.ObjMapperUtils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjMapperUtils.convertJsonToJava;
public class C16_AssignmentPostRequest extends BaseUrlUser {

    @Test
    public void postRequest() {

        spec.pathParams("first", "users");
        String strJson= """
                {
                             "firstName": "John1",
                             "lastName": "Doe1",
                             "birthdate": "1970-02-01",
                              "email": "jdoe@fake2.com",
                              "phone": "80055555552",
                               "street1": "1 Main St2.",
                               "street2": "Apartment A2",
                                "city": "Anytown2",
                                 "stateProvince": "KS2",
                                 "postalCode": "123452",
                                  "country": "USA2"
                         }
                """;
        UserContact expectedData = convertJsonToJava(strJson, UserContact.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        UserContact actualData = convertJsonToJava(response.asString(), UserContact.class);
        System.out.println("actualData = " + actualData);




    }
}
