package AssignmentRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_Assignment {
    @Test
    public void assertMethod(){

//    User send a GET Request to the url
        Response response = RestAssured.get("https://reqres.in/api/unknown/3");
        response.prettyPrint();

//        HTTP Status Code should be 200
        int statusCode = response.statusCode();
        System.out.println("Status Code = " + statusCode);
        response.then().statusCode(200);

//        Response content type is "application/json; charset=utf-8"
        String contentType = response.contentType();
        System.out.println("Content Type = " + contentType);
        response.then().contentType("application/json");

        //Convert Response to JsonPath object
        JsonPath jsonPath = response.jsonPath();

        //Retrieve the data by using JsonPath object
        int id = jsonPath.getInt("data.id");
        String name = jsonPath.getString("data.name");
        int year = jsonPath.getInt("data.year");
        String color = jsonPath.getString("data.color");
        String pantone_value = jsonPath.getString("data.pantone_value");
        String url = jsonPath.getString("support.url");
        String text = jsonPath.getString("support.text");

        //Create SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        //2nd step: Do assertion
        softAssert.assertEquals(contentType,"application/json");
        softAssert.assertEquals(statusCode,200);
        softAssert.assertEquals(id, 3);
        softAssert.assertEquals(name, "true red");
        softAssert.assertEquals(year, 2002);
        softAssert.assertEquals(color,"#BF1932");
        softAssert.assertEquals(pantone_value, "19-1664");
        softAssert.assertEquals(url, "https://reqres.in/#support-heading");
        softAssert.assertEquals(text, "To keep ReqRes free, contributions towards server costs are appreciated!");


        // Use assertAll() method.
        softAssert.assertAll();


        }
        }



