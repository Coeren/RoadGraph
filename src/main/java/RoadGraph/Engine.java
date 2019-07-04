package RoadGraph;

import RoadGraph.Model.Graph;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Engine {
    public boolean checkPath(String graphFile, String instructionFile) throws Exception {
        Graph graph = loadGraph(graphFile);
//        saveGraph(graph, "dump.xml");

        return false;
    }

    private Graph loadGraph(String graphFile) throws JAXBException, SAXException {
        JAXBContext jaxb = JAXBContext.newInstance(Graph.class);
        Unmarshaller loader = jaxb.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema employeeSchema = sf.newSchema(getClass().getResource("/RoadGraph.xsd"));
        loader.setSchema(employeeSchema);

        return (Graph) loader.unmarshal(new File(graphFile));
    }

    private void saveGraph(Graph graph, String filename) throws JAXBException, IOException {
        JAXBContext jaxb = JAXBContext.newInstance(Graph.class);
        Marshaller marshaller = jaxb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (FileOutputStream os = new FileOutputStream(filename))
        {
            marshaller.marshal(graph, os);
        }
    }
}
