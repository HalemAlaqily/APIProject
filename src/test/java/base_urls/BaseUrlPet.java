package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
public class BaseUrlPet {

        protected RequestSpecification spec;
        @BeforeMethod
        public void BeforeMethod(){


            spec = new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io")
                    .setContentType(ContentType.JSON)
                    .build();
        }
}
