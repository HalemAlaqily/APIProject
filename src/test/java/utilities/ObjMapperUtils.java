package utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.JsonPlaceHolderPojo;

public class ObjMapperUtils {

    public static <T> T convertJsonToJava(String strJson, Class<T> valueType) {//Generic method

        try {
            return new ObjectMapper().readValue(strJson, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
