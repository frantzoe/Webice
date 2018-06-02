package factories;

import collections.Conventions;
import models.Convention;
import utilities.JParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class ConventionFactoryImpl implements ConventionFactory {

    private File FILE;

    public ConventionFactoryImpl(String path) {
        this.FILE = new File(path);
    }

    @Override
    public List<Convention> getAll() {
        return getConventions().getConvention();
    }

    @Override
    public Convention getOne(String label) {
        for (Convention convention : getAll()) {
            if (convention.getLabel().equals(label)) {
                return convention;
            }
        }
        return null;
    }

    @Override
    public void create(Convention convention) {
        Conventions conventions = getConventions();
        conventions.getConvention().add(convention);
        setConventions(conventions);
    }

    @Override
    public void update(Convention convention) {
        //**
    }

    @Override
    public void delete(String label) {
        Conventions conventions = getConventions();
        conventions.getConvention().remove(getOne(label));
        setConventions(conventions);
    }

    private Conventions getConventions() {
        try { return JParse.unmarshal(Conventions.class, FILE);
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
    }

    private void setConventions(Conventions conventions) {
        try { JParse.marshal(conventions, FILE, FILE.getPath());
        } catch (JAXBException e) { e.printStackTrace(); }
    }
}
