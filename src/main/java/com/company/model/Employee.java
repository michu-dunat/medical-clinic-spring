package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull(message = "First name cannot be null!")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name cannot be null!")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "license_id")
    private String licenseId;

    @NotNull(message = "Activity cannot be null!")
    @Column(name = "is_active")
    private Boolean isActive;

    @NotNull(message = "Hire date cannot be null!")
    @Column(name = "hire_date")
    private LocalDateTime birthDate;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postcode")
    private String postcode;

    @NotNull(message = "Phone number cannot be null!")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "usersid")
    @NotNull
    private User userId;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private List<Appointment> appointment;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private  List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private  List<Prescription> prescriptions;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private  List<Payment> payments;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private  List<Order> orders;

    @Column(name = "specialisation")
    private String specialisation;

    public Employee(final String id, final String firstName, final String lastName, final String licenseId,
                    final Boolean isActive, final LocalDateTime birthDate, final Float salary, final String address,
                    final String city, final String postcode, final String phoneNumber, final String emailAddress,
                    final User userId, final String specialisation) {
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

    public Employee() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", licenseId='" + licenseId + '\'' +
                ", isActive=" + isActive +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", userId=" + userId.getId() +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}
