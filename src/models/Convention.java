package models;

import services.Candidacies;

import java.util.Date;

public class Convention {

    private String name;
    private String detail;
    private Date date;
    private String place;
    private Integer max;
    private Candidacies candidacies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Candidacies getCandidacies() {
        return candidacies;
    }

    public void setCandidacies(Candidacies candidacies) {
        this.candidacies = candidacies;
    }
}
