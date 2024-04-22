package AssignmentRequests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class C02_Assignment {
    public static void main(String [] args){


//            https://reqres.in/api/users/3

//            User sends a GET Request to the url
        Response response = RestAssured.get(" https://reqres.in/api/users/2");
        response.prettyPrint();
//            HTTP Status Code should be 200
        int statusCode = response.statusCode();
        System.out.println("Status Code = " + statusCode);

//        Response format should be "application/json"
        String ContentType = response.header("Content-Type");
        System.out.println("\nContent Type = " + ContentType);
        Headers headers = response.headers();
        System.out.println("headers = " + headers);


//        "email" is "janet.weaver@reqres.in"
        response.then().body("data.email",equalTo("janet.weaver@reqres.in"));

//        "first_name" is "Janet"
        response.then().body("data.first_name",equalTo("Janet"));
//        "last_name" is "Weaver"
        response.then().body("data.last_name",equalTo("Weaver"));
//        "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }}
