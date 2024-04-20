package AssignmentRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


public class C03_Assignment {

        @Test
        public void assertMethod(){
//    https://reqres.in/api/users/23

//    User send a GET Request to the url
        Response response = RestAssured.get(" https://reqres.in/api/users/23");
        response.prettyPrint();

//    HTTP Status code should be 404
        int statusCode = response.statusCode();
        System.out.println("Status Code = " + statusCode);
//        response.then().statusCode(404);

//    Status Line should be HTTP/1.1 404 Not Found
//        String statusLine = response.statusLine();
//        System.out.println("Status Line = " + statusLine);
//        response.then().statusLine("HTTP/1.1 404 Not Found");

        Assert.assertEquals(statusCode,404);



//    Server is "cloudflare"
    String server = response.header("server");
                System.out.println("server = " + server);

//    Response body should be empty

}}
