package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull(message = "date cannot be null!")
    @Column(name = "date")
    private LocalDateTime date;

    @NotNull(message = "description cannot be null!")
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "patientsid")
    @NotNull
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "employeesid")
    @NotNull
    private Employee employeeId;

    public Prescription() {}

    public Prescription(final LocalDateTime date, final String description,
                        final Patient patientId, final Employee employeeId) {
        this.date = date;
        this.description = description;
        this.patientId = patientId;
        this.employeeId = employeeId;
    }

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

    @Override
    public String toString() {
        return "Prescription{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", patientId=" + patientId.getId() +
                ", employeeId=" + employeeId.getId() +
                '}';
    }
}
