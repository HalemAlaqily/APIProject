package AssignmentRequests;
import base_urls.BaseUrlEmployee;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class C14_Assignment extends BaseUrlEmployee {
    @Test
    void employee() {
        //Set the url
        spec.pathParams("first", "employees");

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();
        response
                .then()
                // Status code is 200?
                .statusCode(200)
                //There are 24 employees?
                .body("data", hasSize(24)
                        //"Tiger Nixon" and "Garrett Winters" are among the employees?
                ,"data.employee_name",hasItems("Tiger Nixon","Garrett Winters")
                        //The greatest age is 66?
                ,"data.employee_age.max()", equalTo(66)
                ,"data.find { it.employee_age == 19 }.employee_name", equalTo("Tatyana Fitzpatrick")//The name of the lowest age is "Tatyana Fitzpatrick"?
                ,"data.employee_salary.sum()", equalTo(6644770));//Total salary of all employees is 6,644,770?

    }
}