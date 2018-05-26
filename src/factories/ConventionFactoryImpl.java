package factories;

import collections.Conventions;
import models.Convention;
import utilities.JParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class ConventionFactoryImpl implements ConventionFactory {

    private String PATH;

    public ConventionFactoryImpl(String path) {
        this.PATH = path;
    }

    @Override
    public List<Convention> getAll() {
        try { Conventions candidacies = JParse.unmarshal(Conventions.class, new File(PATH));
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
        getAll().add(convention);
    }

    @Override
    public void update(Convention convention) {

    }

    @Override
    public void delete(Convention convention) {
        getAll().remove(convention);
    }
}
