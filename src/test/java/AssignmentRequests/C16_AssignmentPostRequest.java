package AssignmentRequests;
import base_urls.BaseUrlUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Assignment16;
import utilities.ObjMapperUtils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static utilities.ObjMapperUtils.convertJsonToJava;
public class C16_AssignmentPostRequest extends BaseUrlUser {

    @Test
    public void postRequest() {

        spec.pathParams("first", "contacts");
        String strJson= """
                {
                             "firstName": "ryo",
                             "lastName": "ricko",
                             "birthdate": "1970-02-01",
                              "email": "jdoe@fake.com",
                              "phone": "0550505050505",
                               "street1": "Main St.",
                               "street2": "Apartment A",
                                "city": "New Mixico",
                                 "stateProvince": "West COst18",
                                 "postalCode": "123452",
                                  "country": "Mixco"
                         }
                """;

        Assignment16 expectedData = new Assignment16 ("John","Doe","1970-01-01",
                "jdoe@fake.com","8005555555", "1 Main St.","Apartment A",
                "Anytown","KS","12345","USA");

        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        Assignment16 actualData = response.as(Assignment16.class);
        System.out.println("actualData = " + actualData);


        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());





    }
}
