package factories;

import collections.Candidates;
import models.Candidate;
import utilities.JParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class CandidateFactoryImpl implements CandidateFactory {

    private File FILE;

    public CandidateFactoryImpl(String path) {
        this.FILE = new File(path);
    }

    @Override
    public List<Candidate> getAll() {
        return getCandidates().getCandidate();
    }

    @Override
    public Candidate getOne(String email) {
        for (Candidate candidate : getAll()) {
            if (candidate.getEmail().equals(email)) {
                return candidate;
            }
        }
        return null;
    }

    @Override
    public void create(Candidate candidate) {
        Candidates candidates = getCandidates();
        candidates.getCandidate().add(candidate);
        setCandidates(candidates);
    }

    @Override
    public void update(Candidate candidate) {
        //**
    }

    @Override
    public void delete(String email) {
        Candidates candidates = getCandidates();
        candidates.getCandidate().remove(getOne(email));
        setCandidates(candidates);
    }

    private Candidates getCandidates() {
        try { return JParse.unmarshal(Candidates.class, FILE);
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
    }

    private void setCandidates(Candidates candidacies) {
        try { JParse.marshal(candidacies, FILE, FILE.getPath());
        } catch (JAXBException e) { e.printStackTrace(); }
    }
}
