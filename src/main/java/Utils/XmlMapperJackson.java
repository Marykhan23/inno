package Utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlMapperJackson {
    private XmlMapper mapper = new XmlMapper();
    public <T> T deserializer(File file, Class clazz){
        XmlMapper mapper = new XmlMapper();
        try {
            return (T)mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public <T> T serializer(File file, Object o){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(file, o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
