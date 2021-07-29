package Utils;

import java.io.*;
import java.nio.file.Path;

public class FilesUtils {
    public static void fileWriter(File file, String string) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(string);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fw.close();
    }
    public static void fileReader(File file, String path) throws IOException {
        FileReader fr = new FileReader(path);
        while(fr.ready()){
            System.out.print((char)fr.read());
        }
        fr.close();
    }
    public static void serializeObject(String path, Object o) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        oos.close();
    }
    public static void deserializeObject(String path, Object o) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        o = ois.readObject();
        ois.close();
    }
}
