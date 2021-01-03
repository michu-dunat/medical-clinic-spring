package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Account`s login must not be empty!")
    @NotEmpty(message = "Account`s login must not be empty!")
    @Column(name = "username")
    private String username;

    @Column(name = "pesel")
    private String pesel;

    @NotBlank(message = "Account`s password must not be empty!")
    @NotEmpty(message = "Account`s password must not be empty!")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Role cannot be empty!")
    @NotEmpty(message = "Role cannot be empty!")
    @Column(name = "role")
    private String role;

    public User(){}

    public User(@NotNull final String username, final String pesel, @NotNull final String password, @NotNull final String role) {
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
