package Utils;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.Writer;


public class XMLMapperJavaxXml{
//    private final Marshaller marshaller;
//    private final Unmarshaller unmarshaller;
//
//    public XMLMapperJavaxXml(Class... clazz) {
//        try {
//            JAXBContext ctx = JAXBContext.newInstance(clazz);
//            marshaller = ctx.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//            unmarshaller = ctx.createUnmarshaller();
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public <T> T unmarshall(Reader reader) {
//        try {
//            return (T) unmarshaller.unmarshal(reader);
//        } catch (JAXBException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    public void marshall(Object instance, Writer writer) {
//        try {
//            marshaller.marshal(instance, writer);
//        } catch (JAXBException e) {
//            throw new IllegalStateException(e);
//        }
//    }
}
