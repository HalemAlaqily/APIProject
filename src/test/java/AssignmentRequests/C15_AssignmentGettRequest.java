package AssignmentRequests;
import base_urls.BaseUrlUser;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserContact;
import pojos.UserPojoRes;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class C15_AssignmentGettRequest  extends BaseUrlUser{
    @Test
    public void putRequest(){

        spec.pathParams("first", "users","second","me");
        UserPojoRes expectedData = new UserPojoRes("firstname", "lastname", null, null, "email");
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
        UserPojoRes actualData = response.as(UserPojoRes.class);
        System.out.println("actualData = " + actualData);



    }}
