package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import AssignmentRequests.*;
import static utilities.Authentication.generateToken;
public class BaseUrlUser {
    protected RequestSpecification spec;
    @BeforeMethod
    public void BeforeMethod(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer " + C15_AssignmentPutRequest.class)//generateToken() method will create a fresh token for each run.
                .setContentType(ContentType.JSON)
                .build();
    }
}
