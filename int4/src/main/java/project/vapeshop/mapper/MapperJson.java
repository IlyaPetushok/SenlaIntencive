package project.vapeshop.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperJson {
    private static final ObjectMapper objectMapper=new ObjectMapper();

    public static String mapperToJson(Object object) {
        String json= null;
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
