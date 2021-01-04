package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Company name cannot be empty!")
    @NotEmpty(message = "Company name cannot be empty!")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "NIP cannot be empty!")
    @NotEmpty(message = "NIP cannot be empty!")
    @Column(name = "nip")
    private long nip;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postcode")
    private String postcode;

    @OneToMany(mappedBy = "companyId", cascade = CascadeType.ALL)
    private List<Payment> payments;

    public Company(@NotNull final String companyName, @NotNull final long nip, final String address,
                   final String city, final String postcode) {
        this.companyName = companyName;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }

    public Company() {}

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public long getNip() {
        return nip;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setNip(long nip) {
        this.nip = nip;
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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", nip=" + nip +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
