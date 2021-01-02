package com.company.Entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String username;
    private String password;
    private String role;
    private long pesel;

    public User(int id, String username, String password, String role, long pesel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.pesel = pesel;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public long getPesel() {
        return pesel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
}
