package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    @MapsId
    @JoinColumn(name = "id")
    private Patient patient;

    public MedicalRecord(int id, @NotNull(message = "Description cannot be null") String description, @NotNull(message = "Date cannot be null") LocalDateTime date, byte[] attachment, Patient patient) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.attachment = attachment;
        this.patient = patient;
    }

    public MedicalRecord() {

    }

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}

