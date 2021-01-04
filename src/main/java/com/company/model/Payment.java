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

    @ManyToOne
    @JoinColumn(name = "patientsid")
    @NotNull
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "companiesid")
    private Company companyId;

    @ManyToOne
    @JoinColumn(name = "employeesid")
    @NotNull
    private Employee employeeId;

    @OneToOne
    @JoinColumn(name = "invoicesid")
    private Invoice invoiceId;

    @OneToOne(mappedBy = "paymentId", cascade = CascadeType.ALL)
    private Order order;

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

    public void setPatientId(Patient patient) {
        this.patientId = patient;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company company) {
        this.companyId = company;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employee) {
        this.employeeId = employee;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoice) {
        this.invoiceId = invoice;
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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", totalPrice=" + totalPrice +
                ", patientId=" + patientId.getId() +
                ", companyId=" + companyId.getId() +
                ", employeeId=" + employeeId.getId() +
                ", invoiceId=" + invoiceId.getId() +
                '}';
    }
}
