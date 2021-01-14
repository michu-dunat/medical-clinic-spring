package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @SequenceGenerator(name="appointments_id_seq",
                        sequenceName = "appointments_id_seq",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointments_id_seq")
    @Column(name = "id")
    private int id;

    @NotNull(message = "Room number cannot be null")
    @Column(name = "room_number")
    private String roomNumber;

    @NotNull(message = "Date cannot be null")
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "patientsid")
    @NotNull
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "employeesid")
    @NotNull
    private Employee employeeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Appointment() {}

    public Appointment(final String roomNumber, final LocalDate date, final Patient patientId,
                       final Employee employeeId) {
        this.roomNumber = roomNumber;
        this.date = date;
        this.patientId = patientId;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", date=" + date +
                ", patientId=" + patientId.getId() +
                ", employeeId=" + employeeId.getId() +
                '}';
    }
}
