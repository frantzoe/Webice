package factories;

import models.Recruiter;

import java.util.List;

public interface RecruiterFactory {
    //**
    List<Recruiter> getAll();
    //**
    Recruiter getOne(String email);
    //**
    void create(Recruiter recruiter);
    //**
    void update(Recruiter recruiter);
    //**
    void delete(Recruiter recruiter);
}
