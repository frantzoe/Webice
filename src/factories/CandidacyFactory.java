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
    Candidacy getOne(Candidate candidate, Convention convention);
    //**
    void create(Candidacy candidacy);
    //**
    void update(Candidacy candidacy);
    //**
    void delete(Candidacy candidacy);
    //**
    void validate(Candidacy candidacy, String choice);
    //**
    void validate(Candidate candidate, Convention convention);

}
