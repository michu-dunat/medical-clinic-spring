package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private Patient patient;

    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private Employee employee;

    public User() {}

    public User(final String username, final Long pesel, final String password, final Role role) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
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

    public List<String> getRoleList(){
        String roleString = this.role.getRole();
        if(roleString.length() > 0){
            return Arrays.asList(roleString.split(","));
        }
        return new ArrayList<>();
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
