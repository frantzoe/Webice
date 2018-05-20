package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "candidacy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidacy {

    private Convention convention;
    private Candidate candidate;
    private List<String> positions;
    private String motivation;
    private Boolean validated;

    public Candidacy() {
        //**
    }

    public Candidacy(Convention convention, Candidate candidate, List<String> positions, String motivation, Boolean validated) {
        this.convention = convention;
        this.candidate = candidate;
        this.positions = positions;
        this.motivation = motivation;
        this.validated = validated;
    }

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidacy)) return false;
        Candidacy candidacy = (Candidacy) o;
        return Objects.equals(convention, candidacy.convention) &&
                Objects.equals(candidate, candidacy.candidate) &&
                Objects.equals(positions, candidacy.positions) &&
                Objects.equals(motivation, candidacy.motivation) &&
                Objects.equals(validated, candidacy.validated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convention, candidate, positions, motivation, validated);
    }

    @Override
    public String toString() {
        return "Candidacy{" +
                "convention=" + convention +
                ", candidate=" + candidate +
                ", positions=" + positions +
                ", motivation='" + motivation + '\'' +
                ", validated=" + validated +
                '}';
    }
}
