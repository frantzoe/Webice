package factories;

import models.Convention;

import java.util.List;

public interface ConventionFactory {
    //**
    List<Convention> getAll();
    //**
    Convention getOne(String label);
    //**
    void create(Convention convention);
    //**
    void update(Convention convention);
    //**
    void delete(String label);
}
