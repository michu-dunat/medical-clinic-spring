package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Service name cannot be null!")
    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "price")
    private Float price;

    @Column(name = "service_description")
    private String serviceDescription;

    @ManyToMany(mappedBy = "services")
    private List<Order> orders;

    public Service() {}

    public Service(final String serviceName, final Float price, final String serviceDescription) {
        this.serviceName = serviceName;
        this.price = price;
        this.serviceDescription = serviceDescription;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                ", serviceDescription='" + serviceDescription + '\'' +
                '}';
    }
}
