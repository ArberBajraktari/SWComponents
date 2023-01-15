package at.fhtw.swen3.services.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DtoToJson<T> {

    public static <T> String toJson(T t){
        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(t);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return jsonString;
    }

}
