//
// Created by Lincoln on: 2018.05.15 at 12:39:22 AM CEST
//

package collections;

import models.Recruiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Recruiters complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"recruiter"})
@XmlRootElement(name = "recruiters")
public class Recruiters {

    @XmlElement(required = true)
    protected List<Recruiter> recruiter;

    /**
     * Gets the value of the recruiter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recruiter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecruiter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Recruiter }
     * 
     * 
     */
    public List<Recruiter> getRecruiter() {
        if (recruiter == null) {
            recruiter = new ArrayList<>();
        }
        return this.recruiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recruiters)) return false;
        Recruiters that = (Recruiters) o;
        return Objects.equals(recruiter, that.recruiter);
    }

    @Override
    public int hashCode() {

        return Objects.hash(recruiter);
    }

    @Override
    public String toString() {
        return "Recruiters{" +
                "recruiter=" + recruiter +
                '}';
    }
}
