package com.company.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
}
