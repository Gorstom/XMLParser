package org.example.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Match")
public class Match {
    private String date;
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;

    @XmlAttribute(name = "Date")
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    @XmlElement(name = "TeamA")
    public String getTeamA() { return teamA; }
    public void setTeamA(String teamA) { this.teamA = teamA; }

    @XmlElement(name = "TeamB")
    public String getTeamB() { return teamB; }
    public void setTeamB(String teamB) { this.teamB = teamB; }

    @XmlElement(name = "ScoreA")
    public int getScoreA() { return scoreA; }
    public void setScoreA(int scoreA) { this.scoreA = scoreA; }

    @XmlElement(name = "ScoreB")
    public int getScoreB() { return scoreB; }
    public void setScoreB(int scoreB) { this.scoreB = scoreB; }

    @Override
    public String toString() {
        return String.format("%s vs %s: %d-%d (%s)", teamA, teamB, scoreA, scoreB, date);
    }
}
