package services;

import models.Convention;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Conventions {

    private List<Convention> conventions;

    public List<Convention> getConventions() {
        return conventions;
    }

    public void setConventions(List<Convention> conventions) {
        this.conventions = conventions;
    }

    public void addConvention(Convention convention) {
        conventions.add(convention);
    }

    @Override
    public String toString() {
        return "Conventions{" + "conventions=" + conventions + '}';
    }
}
