package requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import base_urls.JsonPlaceHolderBaseUrl1;
import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class C24_ObjectMapperPostPojo extends JsonPlaceHolderBaseUrl1 {
    @Test
    public void objectMapperPostPojoTest() throws JsonProcessingException {
        //Set the url
        spec.pathParams("first", "todos");

        //Set the expected data

        String strJson = """
                {
                "userId": 55,
                "title": Tidy your room",
                "completed": false
                }
                """;
        JsonPlaceHolderPojo expectedData = new ObjectMapper().readValue(strJson, JsonPlaceHolderPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPlaceHolderPojo actualData = new ObjectMapper().readValue(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assert response.statusCode()==201 : "Status code did not match";//This is Java assertion
    }

}
