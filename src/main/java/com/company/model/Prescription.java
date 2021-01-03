package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @Column(name = "id")
    private String id;

    @NotBlank(message = "date cannot be empty!")
    @NotEmpty(message = "date cannot be empty!")
    @Column(name = "date")
    private LocalDateTime date;

    @NotBlank(message = "description cannot be empty!")
    @NotEmpty(message = "description cannot be empty!")
    @Column(name = "description")
    private String description;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    @NotNull
    private Patient patientId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    @NotNull
    private Employee employeeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Prescription() {}

    public Prescription(@NotNull final LocalDateTime date, @NotNull final String description,
                        @NotNull final Patient patientId, @NotNull final Employee employeeId) {
        this.date = date;
        this.description = description;
        this.patientId = patientId;
        this.employeeId = employeeId;
    }
}
