package com.company.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> user;

    public Role(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
