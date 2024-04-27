package AssignmentRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import base_urls.JsonPlaceHolderBaseUrl;
import pojos.categoryPojo;
import pojos.tagPojo;
import pojos.petPojo;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;

public class C12_Assignment extends JsonPlaceHolderBaseUrl {
    //Write an automation test that will create, read, update, delete a 'pet' using
    // the "https://petstore.swagger.io/" document
    private petPojo petpojo;
    private tagPojo tagpojo;


    @Test
    public void postPet() {
        //Posting Request
        spec.pathParams("first", "v2","second","pet");
        categoryPojo categoryPojos = new categoryPojo(0, "Germany");
        ArrayList<String> photoUrList = new ArrayList<>();
        photoUrList.add("Picture of a dog's teeth");
        tagPojo tagPojos = new tagPojo(0, "Seaweed");
        ArrayList<tagPojo> pojoTags = new ArrayList<>();
        pojoTags.add(tagPojos);
        petPojo actualData1 = new petPojo(0, categoryPojos, "doggie", photoUrList, pojoTags, "available");

        //sending Request
        System.out.println("actualData = " + actualData1);
        Response response = given(spec).body(actualData1).post("{first}/{second}");
        response.jsonPath().prettyPrint();

        //Get Request
        Response response2 = given().get("https://petstore.swagger.io/v2/pet/9223372036854775807");
        response2.jsonPath().prettyPrint();

        //Update Reqyest
        actualData1.setId(1);
        actualData1.setName("MARSHALL-D-TEACH");
        actualData1.getCategory().setName("zorro");
        actualData1.getPhotoUrls().add("Picture of dog's bone");
        System.out.println("actualData1 = " + actualData1);

        //Delete Request
        Response respose = given(spec).delete("https://petstore.swagger.io/v2/pet/9223372036854775807");
        respose.jsonPath().prettyPrint();


    }

}

