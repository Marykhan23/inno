import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserTests {

    User user = new User();
    @Test
    void user1() throws IOException, ClassNotFoundException {
//        System.out.println(user);
//        String string = "Space   space     space ";
//        StringUtils.normalizeSpace(string);
//        Pattern pattern  = Pattern.compile("[ac]");
//        Matcher matcher = pattern.matcher(string);
//        while (matcher.find()) System.out.print(matcher.group());
//        Path path = Paths.get("C:\\firstGradle\\target");
//        Path path = Path.of("C:\\firstGradle\\target");
        String pathS = "C:\\firstGradle\\target\\crazy_file.txt";
//        File file = new File(pathS);
//        System.out.println(Arrays.toString(file.list()));
//        FileWriter fw = new FileWriter(file);
//        fw.write("Щенок");
//        fw.flush();
//        fw  .close();
//
//        FileReader fr = new FileReader(pathS);
//        while(fr.ready()){
//            System.out.print((char)fr.read());
//        }
//        fr.close();
        //serializarion
//        FileOutputStream fos = new FileOutputStream(pathS);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(user);
//        oos.close();
//        //deserialization
//        FileInputStream fis = new FileInputStream(pathS);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        User user2 = (User) ois.readObject();
//        ois.close();
//        System.out.println(user2);
        Path path = Paths.get("C:\\firstGradle\\target\\after 1717.txt");
//        Files.createFile(path);
        byte[] arrByte = Files.readAllBytes(path);
        Path path2 = Paths.get("C:\\firstGradle\\target\\after 1718.txt");
        Files.write(path2, arrByte);
    }
}
