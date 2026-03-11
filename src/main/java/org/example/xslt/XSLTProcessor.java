package org.example.xslt;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;
import java.io.File;

public class XSLTProcessor {

    public static void transform(String xmlPath, String xsltPath) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource(new File(xsltPath));
        Transformer transformer = factory.newTransformer(xslt);

        StreamSource xml = new StreamSource(new File(xmlPath));
        StringWriter writer = new StringWriter();
        transformer.transform(xml, new StreamResult(writer));

        System.out.println("Wynik transformacji z arkusza: " + new File(xsltPath).getName());
        System.out.println(writer.toString());
    }
}