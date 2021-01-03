package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message =  "Service name cannot be empty!")
    @NotBlank(message = "Service name cannot be empty!")
    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "price")
    private float price;

    @Column(name = "service_description")
    private String serviceDescription;

    @ManyToMany(mappedBy = "orders")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Service() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Service(int id, @NotEmpty(message = "Service name cannot be empty!") @NotBlank(message = "Service name cannot be empty!") String serviceName, float price, String serviceDescription) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
        this.serviceDescription = serviceDescription;
    }
}
