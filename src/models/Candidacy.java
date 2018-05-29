//
// Generated by Lincoln on: 2018.05.15 at 12:42:33 AM CEST
//

package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


/**
 * <p>Java class for Candidacy complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candidacy", propOrder = {"convention", "candidate", "choiceOne", "choiceTwo", "motivation", "validated"})
public class Candidacy {

    @XmlElement(required = true)
    protected Convention convention;
    @XmlElement(required = true)
    protected Candidate candidate;
    @XmlElement(required = true)
    protected String choiceOne;
    @XmlElement(required = true)
    protected String choiceTwo;
    @XmlElement(required = true)
    protected String motivation;
    protected Boolean validated;

    /**
     * Gets the value of the convention property.
     * 
     * @return
     *     possible object is
     *     {@link Convention }
     *     
     */
    public Convention getConvention() {
        return convention;
    }

    /**
     * Sets the value of the convention property.
     * 
     * @param value
     *     allowed object is
     *     {@link Convention }
     *     
     */
    public void setConvention(Convention value) {
        this.convention = value;
    }

    /**
     * Gets the value of the candidate property.
     * 
     * @return
     *     possible object is
     *     {@link Candidate }
     *     
     */
    public Candidate getCandidate() {
        return candidate;
    }

    /**
     * Sets the value of the candidate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Candidate }
     *     
     */
    public void setCandidate(Candidate value) {
        this.candidate = value;
    }

    /**
     * Gets the value of the choiceOne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoiceOne() {
        return choiceOne;
    }

    /**
     * Sets the value of the choiceOne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoiceOne(String value) {
        this.choiceOne = value;
    }

    /**
     * Gets the value of the choiceTwo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoiceTwo() {
        return choiceTwo;
    }

    /**
     * Sets the value of the choiceTwo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoiceTwo(String value) {
        this.choiceTwo = value;
    }

    /**
     * Gets the value of the motivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivation() {
        return motivation;
    }

    /**
     * Sets the value of the motivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivation(String value) {
        this.motivation = value;
    }

    /**
     * Gets the value of the validated property.
     * 
     */
    public Boolean getValidated() {
        return validated;
    }

    /**
     * Sets the value of the validated property.
     * 
     */
    public void setValidated(Boolean value) {
        this.validated = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidacy)) return false;
        Candidacy candidacy = (Candidacy) o;
        return Objects.equals(convention, candidacy.convention) &&
                Objects.equals(candidate, candidacy.candidate) &&
                Objects.equals(choiceOne, candidacy.choiceOne) &&
                Objects.equals(choiceTwo, candidacy.choiceTwo) &&
                Objects.equals(motivation, candidacy.motivation) &&
                Objects.equals(validated, candidacy.validated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convention, candidate, choiceOne, choiceTwo, motivation, validated);
    }

    @Override
    public String toString() {
        return "Candidacy{" +
                "convention=" + convention +
                ", candidate=" + candidate +
                ", choiceOne='" + choiceOne + '\'' +
                ", choiceTwo='" + choiceTwo + '\'' +
                ", motivation='" + motivation + '\'' +
                ", validated=" + validated +
                '}';
    }
}
