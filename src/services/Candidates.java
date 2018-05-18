package services;

import models.Candidate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "candidates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidates {

    @XmlElement(name = "candidate")
    private List<Candidate> candidates;

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidates)) return false;
        Candidates that = (Candidates) o;
        return Objects.equals(candidates, that.candidates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidates);
    }

    @Override
    public String toString() {
        return "Candidates{" +
                "candidates=" + candidates +
                '}';
    }
}
