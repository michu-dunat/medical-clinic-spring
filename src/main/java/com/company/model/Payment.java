package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    private Patient patientId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    private Company companyId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    @NotNull
    private Employee employeeId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "id")
    private Invoice invoiceId;

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

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Payment() {}

    public Payment(final LocalDateTime date, final String paymentMethod, final String paymentStatus,
                    final float totalPrice,  final Patient patientId, final Company companyId,
                    final Employee employeeId, final Invoice invoiceId) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.totalPrice = totalPrice;
        this.patientId = patientId;
        this.companyId = companyId;
        this.employeeId = employeeId;
        this.invoiceId = invoiceId;
    }
}
