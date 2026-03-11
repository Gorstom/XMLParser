package org.example;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.example.jaxb.Matches;
import org.example.sax.FootballSAXHandler;
import org.example.xslt.XSLTProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String XML_FILE = "src/main/xml/sample.xml";
    private static final String XSLT_DIR = "src/main/resources/xslt/";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Processing JAXB");
        processWithJAXB(XML_FILE);

        System.out.println("\n2. Processing SAX");
        processWithSAX(XML_FILE);

        System.out.println("\n3. Processing DOM");
        processWithDOM(XML_FILE);

        System.out.println("\n4. Transformation XSLT");
        System.out.println("Available sheets:");
        File xsltDir = new File(XSLT_DIR);
        File[] xsltFiles = xsltDir.listFiles((dir, name) -> name.endsWith(".xslt"));

        if (xsltFiles != null && xsltFiles.length > 0) {
            for (int i = 0; i < xsltFiles.length; i++) {
                System.out.println((i + 1) + ". " + xsltFiles[i].getName());
            }

            System.out.print("Choose sheet (1-" + xsltFiles.length + "): ");
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= xsltFiles.length) {
                XSLTProcessor.transform(XML_FILE, xsltFiles[choice - 1].getPath());
            } else {
                System.out.println("Incorrect choice!");
            }
        }

    }

    private static void processWithJAXB(String xmlPath) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Matches.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Matches matches = (Matches) unmarshaller.unmarshal(new File(xmlPath));
        matches.printMatches();
    }

    private static void processWithSAX(String xmlPath) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(new File(xmlPath), new FootballSAXHandler());
    }

    private static void processWithDOM(String xmlPath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(xmlPath));

        doc.getDocumentElement().normalize();
        System.out.println("Processing DOM:");

        NodeList matchList = doc.getElementsByTagName("Match");
        for (int i = 0; i < matchList.getLength(); i++) {
            Node matchNode = matchList.item(i);
            if (matchNode.getNodeType() == Node.ELEMENT_NODE) {
                Element matchElement = (Element) matchNode;

                String date = matchElement.getAttribute("Date");
                String teamA = matchElement.getElementsByTagName("TeamA").item(0).getTextContent();
                String teamB = matchElement.getElementsByTagName("TeamB").item(0).getTextContent();
                String scoreA = matchElement.getElementsByTagName("ScoreA").item(0).getTextContent();
                String scoreB = matchElement.getElementsByTagName("ScoreB").item(0).getTextContent();

                System.out.printf("%s vs %s: %s-%s (%s)%n",
                        teamA, teamB, scoreA, scoreB, date);
            }
        }
    }
}