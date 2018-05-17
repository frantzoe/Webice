package services;

import models.Candidacy;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Candidacies {

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
    public String toString() {
        return "Candidacies{" + "candidacies=" + candidacies + '}';
    }
}
