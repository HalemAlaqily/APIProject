package AssignmentRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class C01_Assignment {
    public static void main(String [] args){

//            https://reqres.in/api/users/3

//            User sends a GET Request to the url
        Response response = RestAssured.get(" https://reqres.in/api/users/3");
        response.prettyPrint();
//            HTTP Status Code should be 200

        int statusCode = response.statusCode();
        System.out.println("Status Code = " + statusCode);
        response.then().statusCode(200);

//            Content Type should be JSON
        String contentType = response.contentType();
        System.out.println("Content Type = " + contentType);
        response.then().contentType("application/json");

//            Status Line should be HTTP/1.1 200 OK
        String statusLine = response.statusLine();
        System.out.println("Status Line = " + statusLine);
        response.then().statusLine("HTTP/1.1 200 OK");


    }}
