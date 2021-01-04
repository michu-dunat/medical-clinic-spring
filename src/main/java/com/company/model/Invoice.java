package com.company.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Invoice cannot be null")
    @Column(name = "invoice")
    private byte[] invoice;

    @OneToOne(mappedBy = "invoiceId", cascade = CascadeType.ALL)
    private Payment payments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getInvoice() {
        return invoice;
    }

    public void setInvoice(byte[] invoice) {
        this.invoice = invoice;
    }

    public Invoice() {}

    public Invoice(final byte[] invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoice=" + Arrays.toString(invoice) +
                '}';
    }
}
