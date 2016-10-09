package org.jboss.qa.examples.bpm_taxi;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.assertj.core.api.Assertions;
import org.jboss.qa.examples.bpm_taxi.util.RegistryDataGenerator;
import org.junit.Test;

public class RegistryMarshallingTest {

    private static final File XML_FILE = new File(System.getProperty("java.io.tmpdir", "/tmp"), "testRegistry.xml");

    @Test
    public void testMarshallUnmarshall() {
        RegistryDataGenerator registryDataGenerator = new RegistryDataGenerator();
        Registry generatedRegistry = registryDataGenerator.generateRegistry();

        writeData(generatedRegistry, XML_FILE);
        Registry fromXmlFile = readData(XML_FILE);

        assertRegistry(generatedRegistry, fromXmlFile);
    }

    private void assertRegistry(Registry expected, Registry retrieved) {
        Assertions.assertThat(retrieved).isEqualToComparingFieldByField(expected);
    }

    private void writeData(Registry registry, File xmlFile) {
        Marshaller marshaller = createJaxbMarshaller();
        try {
            marshaller.marshal(registry, xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException("Unable to marshall taxi registry.", e);
        }
    }

    private Registry readData(File xmlFile) {
        try {
            return (Registry) createJaxbUnmarshaller().unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException("Unable to unmarshall taxi registry.", e);
        }
    }

    private  Marshaller createJaxbMarshaller() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Registry.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            return marshaller;
        } catch (JAXBException jaxbException) {
            throw new RuntimeException("Unable to create marshaller.", jaxbException);
        }
    }

    private  Unmarshaller createJaxbUnmarshaller() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Registry.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller;
        } catch (JAXBException jaxbException) {
            throw new RuntimeException("Unable to create unmarshaller.", jaxbException);
        }
    }
}
