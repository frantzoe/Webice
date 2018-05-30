package factories;

import collections.Candidacies;
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
        try { Candidacies candidacies = JParse.unmarshal(Candidacies.class, FILE);
            return candidacies.getCandidacy();
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public Candidacy getOne(Candidate candidate, Convention convention) {
        for (Candidacy candidacy : getAll()) {
            if (candidacy.getCandidate().equals(candidate) && candidacy.getConvention().equals(convention)) {
                return candidacy;
            }
        }
        return null;
    }

    @Override
    public void create(Candidacy candidacy) {
        try { List<Candidacy> candidacies = getAll();
            candidacies.add(candidacy);
            JParse.marshal(candidacies, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Candidacy candidacy) {
        //**
    }

    @Override
    public void delete(Candidacy candidacy) {
        try { List<Candidacy> candidacies = getAll();
            candidacies.remove(candidacy);
            JParse.marshal(candidacies, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void validate() {

    }
}
