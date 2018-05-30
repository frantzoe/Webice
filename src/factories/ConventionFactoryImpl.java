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
        try { Conventions candidacies = JParse.unmarshal(Conventions.class, FILE);
            return candidacies.getConvention();
        } catch (JAXBException e) { e.printStackTrace(); }
        return null;
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
        try { List<Convention> conventions = getAll();
            conventions.add(convention);
            JParse.marshal(conventions, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Convention convention) {
        //**
    }

    @Override
    public void delete(Convention convention) {
        try { List<Convention> conventions = getAll();
            conventions.remove(convention);
            JParse.marshal(conventions, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
