package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Description cannot be null!")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Date cannot be null!")
    @Column(name = "date")
    private LocalDateTime date;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private Patient patientId;

    public Notification(final String description, final LocalDateTime date, final Patient patientId) {
        this.description = description;
        this.date = date;
        this.patientId = patientId;
    }

    public Notification() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", patientId=" + patientId.getId() +
                '}';
    }
}
