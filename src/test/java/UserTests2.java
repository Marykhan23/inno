import Utils.JsonMapperJackson;
import Utils.XmlMapperJackson;
import Utils.XmlParser;
import org.junit.jupiter.api.Test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.*;

@XmlRootElement(name="User")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserTests2 {
    @Test
    void xmlTest() throws IOException {
        User user = new User();
        System.out.println(user);
        XmlParser parser = new XmlParser(User.class);
        Writer wr = new FileWriter("target\\firstXml.txt");
        parser.marshall(user, wr);

        User user2 = parser.unmarshall(new FileReader("target\\firstXml.txt"));
        System.out.println(user2);
    }
    @Test
    void xmlTest2() throws IOException {
        XmlMapperJackson mapper = new XmlMapperJackson();
        User user2 = mapper.deserializer(new File("target\\firstXml.txt"), User.class);
        System.out.println(user2);
    }
    @Test
    void xmlTest3() throws IOException {
        User user = new User();
        System.out.println(user);
        XmlMapperJackson mapper = new XmlMapperJackson();
        mapper.serializer(new File("target\\thirdXml.txt"), user);
    }
    @Test
    void jsonSerialize() throws IOException {
        User user = new User();
        System.out.println(user);
        JsonMapperJackson mapper = new JsonMapperJackson();
        mapper.serializeJson(new File("target\\serializeJson.txt"), user);
    }
    @Test
    void jsonDeserialize() throws IOException {
        JsonMapperJackson mapper = new JsonMapperJackson();
        User user2 = mapper.deserializeJson(new File("target\\serializeJson.txt"), User.class);
        System.out.println("Deserialize jason " + user2);
    }
}
