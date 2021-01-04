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
    private int id;

    @OneToOne
    @NotNull
    @JoinColumn(name = "paymentsid")
    private Payment paymentId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "patientsid")
    private Patient patientId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employeesid")
    private Employee employeeId;

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Order(final Payment paymentId, final Patient patientId, final Employee employeeId, final List<Service> services) {
        this.paymentId = paymentId;
        this.patientId = patientId;
        this.employeeId = employeeId;
        this.services = services;
    }

    public Order() {}

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", paymentId=" + paymentId.getId() +
                ", patientId=" + patientId.getId() +
                ", employeeId=" + employeeId.getId() +
                '}';
    }
}
