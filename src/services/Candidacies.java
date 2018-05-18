package services;

import models.Candidacy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "candidacies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidacies {

    @XmlElement(name = "candidacy")
    private List<Candidacy> candidacies;

    public List<Candidacy> getCandidacies() {
        return candidacies;
    }

    public void setCandidacies(List<Candidacy> candidacies) {
        this.candidacies = candidacies;
    }

    public void addCandidacy(Candidacy candidacy) {
        candidacies.add(candidacy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidacies)) return false;
        Candidacies that = (Candidacies) o;
        return Objects.equals(candidacies, that.candidacies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidacies);
    }

    @Override
    public String toString() {
        return "Candidacies{" + "candidacies=" + candidacies + '}';
    }
}
