package utilities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class JParse {

    public static <T> void marshal(Class<T> c, File f) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(c.getClass());
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.marshal(c, f);
    }

    public static <T> T unmarshal(Class<T> c, File f) throws JAXBException {
        return unmarshal(c, new StreamSource(f));
    }

    public static <T> T unmarshal(Class<T> c, Source s) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        return unmarshaller.unmarshal(s, c).getValue();
    }

}
