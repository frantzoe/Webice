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
        try { Candidates candidates = JParse.unmarshal(Candidates.class, FILE);
            return candidates.getCandidate();
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
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
        try { List<Candidate> candidates = getAll();
            candidates.add(candidate);
            JParse.marshal(candidates, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Candidate candidate) {
        //**
    }

    @Override
    public void delete(Candidate candidate) {
        try { List<Candidate> candidates = getAll();
            candidates.remove(candidate);
            JParse.marshal(candidates, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
