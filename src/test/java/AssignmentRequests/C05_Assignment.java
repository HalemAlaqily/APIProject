package AssignmentRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;

public class C05_Assignment {
//    https://reqres.in/api/unknown/
//    I send GET Request to the URL
    @Test
    public void Assignment(){
        Response response = RestAssured.get("https://reqres.in/api/unknown/");


//            1)Status code is 200
        int statusCode = response.statusCode();
        System.out.println("Status Code = " + statusCode);
        response.then().statusCode(200);

        //Convert Response to JsonPath object
        JsonPath jsonPath = response.jsonPath();

//            2)Print all pantone_values
        List<Integer> pantone_valuesList = jsonPath.getList("data.pantone_values");
        System.out.println("pantone values = " + pantone_valuesList);


//            3)Print all ids greater than 3 on the console
//    Assert that there are 3 ids greater than 3
        List<Integer> idlist = jsonPath.getList("data.id");
        System.out.println("ID = " + idlist);
        int idsGreaterThan3 = 0;
        for (int w : idlist) {

            if (w > 3) {
                System.out.println(w);
                idsGreaterThan3++;
            }

        }

        assertEquals(idsGreaterThan3, 3);


//            4)Print all names whose ids are less than 3 on the console
//    Assert that the number of names whose ids are less than 3 is 2
        List<String> nameslist = jsonPath.getList("data.id");
        System.out.println("name = " + nameslist);
        int idLessThan3 = 0;
        for (int w : idlist) {

            if (w < 3) {
                System.out.println(w);
                idLessThan3++;
            }

        }
        assertEquals(idLessThan3,2);
}}
