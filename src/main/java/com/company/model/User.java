package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Account`s login must not be null!")
    @Column(name = "username")
    private String username;

    @Column(name = "pesel")
    private Long pesel;

    @NotNull(message = "Account`s password must not be null!")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Role cannot be null!")
    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private Patient patient;

    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private Employee employee;

    public User() {}

    public User(final String username, final Long pesel, final String password, final String role) {
        this.pesel = pesel;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pesel='" + pesel + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
