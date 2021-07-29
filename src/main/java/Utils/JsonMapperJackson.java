package Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonMapperJackson {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void serializeJson(File file, Object o){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(file, o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public <T> T deserializeJson(File file, Class clazz){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return (T) objectMapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
