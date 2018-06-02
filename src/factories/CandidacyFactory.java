package factories;

import models.Candidacy;
import models.Candidate;
import models.Convention;

import java.util.List;

public interface CandidacyFactory {
    //**
    List<Candidacy> getAll();
    //**
    Candidacy getOne(String email, String label);
    //**
    void create(Candidacy candidacy);
    //**
    void update(Candidacy candidacy);
    //**
    void delete(String email, String label);
    //**
    void validate(String email, String label, String choice);
    

}
