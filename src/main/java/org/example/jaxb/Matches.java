package org.example.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Matches")
@XmlAccessorType(XmlAccessType.FIELD)
public class Matches {
    @XmlElement(name = "Match")
    private List<Match> matches;

    public List<Match> getMatches() { return matches; }
    public void setMatches(List<Match> matches) { this.matches = matches; }

    public void printMatches() {
        matches.forEach(System.out::println);
    }
}
