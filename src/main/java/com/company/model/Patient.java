package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "first name cannot be null!")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "last name cannot be null!")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "birth date cannot be null!")
    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "blood_type")
    private String bloodType;

    @NotNull(message = "address cannot be null!")
    @Column(name = "address")
    private String address;

    @NotNull(message = "city cannot be null!")
    @Column(name = "city")
    private String city;

    @NotNull(message = "postcode cannot be null!")
    @Column(name = "postcode")
    private String postcode;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "pemanent_city")
    private String permanentCity;

    @Column(name = "permanent_postcode")
    private String permanentPostcode;

    @NotNull(message = "phone number cannot be null!")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "usersid")
    @NotNull
    private User userId;

    @OneToMany(mappedBy = "patientId")
    private List<MedicalRecord> medicalRecords;

    @NotNull(message = "notification status cannot be null!")
    @Column(name = "notifications_status")
    private Boolean notificationStatus;

    public Patient() {}

    public Patient(final String firstName, final String lastName, final LocalDateTime birthDate,
                   final String bloodType, final String address, final String city, final String postcode,
                   final String permanentAddress, final String permanentCity, final String permanentPostcode,
                   final String phoneNumber, final String contactPhone, final String emailAddress,
                   final User userId, final Boolean notificationStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.bloodType = bloodType;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.permanentAddress = permanentAddress;
        this.permanentCity = permanentCity;
        this.permanentPostcode = permanentPostcode;
        this.phoneNumber = phoneNumber;
        this.contactPhone = contactPhone;
        this.emailAddress = emailAddress;
        this.userId = userId;
        this.notificationStatus = notificationStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }

    public String getPermanentPostcode() {
        return permanentPostcode;
    }

    public void setPermanentPostcode(String permanentPostcode) {
        this.permanentPostcode = permanentPostcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Boolean isNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(Boolean notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
}

