package org.example.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FootballSAXHandler extends DefaultHandler {
    private StringBuilder currentValue = new StringBuilder();
    private String currentElement;
    private int matchCount = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentValue.setLength(0);
        currentElement = qName;

        if ("Match".equals(qName)) {
            matchCount++;
            System.out.println("\nMatch #" + matchCount);
            if (attributes.getLength() > 0) {
                System.out.println("Date: " + attributes.getValue("Date"));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("TeamA".equals(qName)) {
            System.out.println("Team A: " + currentValue);
        } else if ("TeamB".equals(qName)) {
            System.out.println("Team B: " + currentValue);
        } else if ("ScoreA".equals(qName)) {
            System.out.println("Score A: " + currentValue);
        } else if ("ScoreB".equals(qName)) {
            System.out.println("Score B: " + currentValue);
        }
    }
}
