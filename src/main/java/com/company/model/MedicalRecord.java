package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Description cannot be null")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Date cannot be null")
    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "attachment")
    private byte[] attachment;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "patientsid")
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "employeesid")
    @NotNull
    private Employee employeeId;

    public MedicalRecord(final String description, final LocalDateTime date, final byte[] attachment,
                         final Patient patientId, final Employee employeeId) {
        this.description = description;
        this.date = date;
        this.attachment = attachment;
        this.patientId = patientId;
        this.employeeId = employeeId;
    }

    public MedicalRecord() {}

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

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patient) {
        this.patientId = patient;
    }

    public Employee getEmployeeId() {return employeeId;}

    public void setEmployeeId(Employee employeeId) {this.employeeId = employeeId;}

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", attachment=" + Arrays.toString(attachment) +
                ", patientId=" + patientId.getId() +
                ", employeeId=" + employeeId.getId() +
                '}';
    }
}

