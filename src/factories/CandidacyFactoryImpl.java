package factories;

import collections.Candidacies;
import collections.Conventions;
import models.Candidacy;
import models.Candidate;
import models.Convention;
import utilities.JParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class CandidacyFactoryImpl implements CandidacyFactory {

    private File FILE;

    public CandidacyFactoryImpl(String path) {
        this.FILE = new File(path);
    }

    @Override
    public List<Candidacy> getAll() {
        return getCandidacies().getCandidacy();
    }

    @Override
    public Candidacy getOne(String email, String label) {
        for (Candidacy candidacy : getAll()) {
            if (candidacy.getCandidate().getEmail().equals(email) && candidacy.getConvention().getLabel().equals(label)) {
                return candidacy;
            }
        }
        return null;
    }

    @Override
    public void create(Candidacy candidacy) {
        Candidacies candidacies = getCandidacies();
        candidacies.getCandidacy().add(candidacy);
        setCandidacies(candidacies);
    }

    @Override
    public void update(Candidacy candidacy) {
        //**
    }

    @Override
    public void delete(String email, String label) {
        Candidacies candidacies = getCandidacies();
        candidacies.getCandidacy().remove(getOne(email, label));
        setCandidacies(candidacies);
    }

    @Override
    public void validate(String email, String label, String choice) {
        Candidacies candidacies = getCandidacies();
        for (Candidacy candidacy : candidacies.getCandidacy()) {
            if (candidacy.getCandidate().getEmail().equals(email) && candidacy.getConvention().getLabel().equals(label)) {
                if (candidacy.getChoiceOne().equals(choice)) {
                    candidacy.setChoiceTwo(null);
                } else {
                    candidacy.setChoiceOne(null);
                }
                candidacy.setValidated(true);
            }
        }
        setCandidacies(candidacies);
    }

    private Candidacies getCandidacies() {
        try { return JParse.unmarshal(Candidacies.class, FILE);
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
    }

    private void setCandidacies(Candidacies candidacies) {
        try { JParse.marshal(candidacies, FILE, FILE.getPath());
        } catch (JAXBException e) { e.printStackTrace(); }
    }
}
