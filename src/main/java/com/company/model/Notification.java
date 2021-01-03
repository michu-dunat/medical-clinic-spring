package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Description cannot be empty!")
    @NotEmpty(message = "Description cannot be empty!")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Date cannot be empty!")
    @NotEmpty(message = "Date cannot be empty!")
    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    @NotNull
    private Patient patientId;

    public Notification(@NotNull final String description, @NotNull final LocalDateTime date, @NotNull final Patient patientId) {
        this.description = description;
        this.date = date;
        this.patientId = patientId;
    }

    public Notification() {

    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }
}
