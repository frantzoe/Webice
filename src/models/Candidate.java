package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "candidate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidate {

    private String forename;
    private String surname;
    private String gender;
    private String birthday;
    private String telephone;
    private String email;

    public Candidate() {
        //**
    }

    public Candidate(String forename, String surname, String gender, String birthday, String telephone, String email) {
        this.forename = forename;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Candidate)) return false;
        Candidate candidate = (Candidate) obj;
        return Objects.equals(forename, candidate.forename) &&
                Objects.equals(surname, candidate.surname) &&
                Objects.equals(gender, candidate.gender) &&
                Objects.equals(birthday, candidate.birthday) &&
                Objects.equals(telephone, candidate.telephone) &&
                Objects.equals(email, candidate.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forename, surname, gender, birthday, telephone, email);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
