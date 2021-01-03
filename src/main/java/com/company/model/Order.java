package com.company.model;

import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @NotNull
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "orders_services",
            joinColumns = {@JoinColumn(name = "ordersid")},
            inverseJoinColumns = {@JoinColumn(name = "servicesid")}
    )
    private List<Service> services;

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
