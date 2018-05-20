package services;

import models.Convention;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "conventions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conventions {

    @XmlElement(name = "convention")
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

    public Convention getConventionByLabel(String label) {
        for (Convention convention : conventions) {
            if (convention.getLabel().equals(label)) {
                return convention;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conventions)) return false;
        Conventions that = (Conventions) o;
        return Objects.equals(conventions, that.conventions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(conventions);
    }

    @Override
    public String toString() {
        return "Conventions{" + "conventions=" + conventions + '}';
    }
}
