package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    private String id;

    @NotBlank(message = "First name cannot be empty!")
    @NotEmpty(message = "First name cannot be empty!")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty!")
    @NotEmpty(message = "Last name cannot be empty!")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "license_id")
    private String licenseId;

    @NotBlank(message = "Activity cannot be empty!")
    @NotEmpty(message = "Activity cannot be empty!")
    @Column(name = "is_active")
    private boolean isActive;

    @NotBlank(message = "Hire date cannot be empty!")
    @NotEmpty(message = "Hire date cannot be empty!")
    @Column(name = "hire_date")
    private LocalDateTime birthDate;

    @Column(name = "salary")
    private float salary;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postcode")
    private String postcode;

    @NotBlank(message = "Phone number cannot be empty!")
    @NotEmpty(message = "Phone number cannot be empty!")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @NotNull
    private User userId;

    @Column(name = "specialisation")
    private String specialisation;

    public Employee(@NotNull final String id, @NotNull final String firstName, @NotNull final String lastName, final String licenseId,
                    @NotNull final boolean isActive, @NotNull final LocalDateTime birthDate,
                    final float salary, final String address, final String city, final String postcode,
                   @NotNull final String phoneNumber, final String emailAddress, @NotNull final User userId,
                    final String specialisation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseId = licenseId;
        this.isActive = isActive;
        this.birthDate = birthDate;
        this.salary = salary;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.userId = userId;
        this.specialisation = specialisation;
    }

    public Employee() {

    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public float getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public User getUserId() {
        return userId;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
