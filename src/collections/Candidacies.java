//
// Generated by Lincoln on: 2018.05.15 at 12:42:33 AM CEST
//

package collections;

import models.Candidacy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Candidacies complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"candidacy"})
@XmlRootElement(name = "candidacies")
public class Candidacies {

    protected List<Candidacy> candidacy;

    /**
     * Gets the value of the candidacy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidacy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidacy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Candidacy }
     * 
     * 
     */
    public List<Candidacy> getCandidacy() {
        if (candidacy == null) {
            candidacy = new ArrayList<>();
        }
        return this.candidacy;
    }

    public void addCandidacy(Candidacy candidacy) {
        this.candidacy.add(candidacy);
    }

}
