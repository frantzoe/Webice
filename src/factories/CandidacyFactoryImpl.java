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

    private String PATH;

    public CandidacyFactoryImpl(String path) {
        this.PATH = path;
    }

    @Override
    public List<Candidacy> getAll() {
        try { Candidacies candidacies = JParse.unmarshal(Candidacies.class, new File(PATH));
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
        getAll().add(candidacy);
    }

    @Override
    public void update(Candidacy candidacy) {
        //**
    }

    @Override
    public void delete(Candidacy candidacy) {
        getAll().remove(candidacy);
    }
}
