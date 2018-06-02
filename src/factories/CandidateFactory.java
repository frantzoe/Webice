package factories;

import models.Candidate;

import java.util.List;

public interface CandidateFactory {
    //**
    List<Candidate> getAll();
    //**
    Candidate getOne(String email);
    //**
    void create(Candidate candidate);
    //**
    void update(Candidate candidate);
    //**
    void delete(String email);
}
