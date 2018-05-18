package models;

import services.Candidacies;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "convention")
@XmlAccessorType(XmlAccessType.FIELD)
public class Convention {

    private String label;
    private String detail;
    private Date scheduled;
    private String place;
    private List<String> positions;

    public Convention() {
        //**
    }

    public Convention(String label, String detail, Date scheduled, String place, List<String> positions) {
        this.label = label;
        this.detail = detail;
        this.scheduled = scheduled;
        this.place = place;
        this.positions = positions;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getScheduled() {
        return scheduled;
    }

    public void setScheduled(Date scheduled) {
        this.scheduled = scheduled;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Convention)) return false;
        Convention that = (Convention) o;
        return Objects.equals(label, that.label) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(scheduled, that.scheduled) &&
                Objects.equals(place, that.place) &&
                Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, detail, scheduled, place, positions);
    }

    @Override
    public String toString() {
        return "Convention{" +
                "label='" + label + '\'' +
                ", detail='" + detail + '\'' +
                ", scheduled=" + scheduled +
                ", place='" + place + '\'' +
                ", positions=" + positions +
                '}';
    }
}
