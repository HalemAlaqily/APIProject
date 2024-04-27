package AssignmentRequests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;
public class C09_Assignment extends JsonPlaceHolderBaseUrl{
    //@Test

    @Test
    public void postTest(){
        spec.pathParams("first", "v2","second","user");
        Map<String, Object> expectedData = new HashMap<>();

        //List<Map<String, Object>> users = new ArrayList<>();
        Map<String,Object> postMap = new HashMap<>();
        postMap.put("id",10);
        postMap.put("username","Ace_D");
        postMap.put("firstName","Ace");
        postMap.put("lastName","Portogas");
        postMap.put("email","meraMeraNomi_gmail.com");
        postMap.put("password","123rog");
        postMap.put("phone","1234567890");
        postMap.put("userStatus","Student");
        //users.add(postMap);
        System.out.println("create new user = " + postMap);
        Response response = given(spec).body(postMap).post("{first}/{second}");
        response.prettyPrint();

        response
                .then()
                .statusCode(500)
                .body(
                        "id", equalTo(postMap.get("id")),
                        "username",equalTo(postMap.get("username"))
                              , "firstName", equalTo(postMap.get("Ace"))
                               , "lastName", equalTo(postMap.get("Portogas"))
                             , "email", equalTo(postMap.get("meraMeraNomi_gmail.com"))
                               , "password", equalTo(postMap.get("123rog"))
                               , "phone", equalTo(postMap.get("1234567890")));







    }

}
