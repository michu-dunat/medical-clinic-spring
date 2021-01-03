package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @NotNull(message = "total price cannot be null!")
    @Column(name = "total_price")
    private float totalPrice;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @NotNull
    private Patient patient;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    private Company company;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    @NotNull
    private Employee employee;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    private Invoice invoice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Payment() {}

    public Payment(final LocalDateTime date, final String paymentMethod, final String paymentStatus,
                    final float totalPrice,  final Patient patientId, final Company companyId,
                    final Employee employeeId, final Invoice invoiceId) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.totalPrice = totalPrice;
        this.patient = patientId;
        this.company = companyId;
        this.employee = employeeId;
        this.invoice = invoiceId;
    }
}
