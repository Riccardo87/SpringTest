package com.project.ecommerce;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Invoice implements InvoiceRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heading;
    private String[] line;
    private Double totalInvoice;

    public Invoice(long id, String heading, String[] line, Double totalInvoice) {
        this.id = id;
        this.heading = heading;
        this.line = line;
        this.totalInvoice = totalInvoice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String[] getLine() {
        return line;
    }

    public void setLine(String[] line) {
        this.line = line;
    }

    public Double getTotalInvoice () {
        return totalInvoice;
    }

    public void setTotalInvoice(double totalInvoice) {
        this.totalInvoice = totalInvoice;
    }

}
