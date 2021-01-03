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
    private String pesel;

    @NotNull(message = "Account`s password must not be null!")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Role cannot be null!")
    @Column(name = "role")
    private String role;

    public User() {}

    public User(final String username, final String pesel, final String password, final String role) {
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
