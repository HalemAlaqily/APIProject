package AssignmentRequests;

import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import base_urls.JsonPlaceHolder_Assignment;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
/*
        https://automationexercise.com/api/productsList
        User sends a GET request
        Assert that the number of "Women" user type is 12
    Note: Print using JsonPath: response.jsonPath().prettyPrint();
*/

public class C11_Assignment extends JsonPlaceHolder_Assignment{
    @Test
    public void postRequestPojoTest(){
        spec.pathParams("first","api","second","productsList");

        Response response = given(spec).get("{first}/{second}");

        response.jsonPath().prettyPrint();

        JsonPath jsonPath = new JsonPath(response.asString());//to-parse-the-json
        //response.then().statusCode(200);
        Object user_Type = jsonPath.getInt("findAll{it.usertype=='Women'}.product");
        System.out.println("User Type = " + user_Type);
        assertEquals(user_Type, 12);

    }

}
