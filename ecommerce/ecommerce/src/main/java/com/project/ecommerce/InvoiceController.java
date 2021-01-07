package com.project.ecommerce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class InvoiceController {
    InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {

        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/invoice/")
    public Iterable<Invoice> getInvoice() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/invoice/{id}")
    public Invoice getInvoice(@PathVariable("id") Long id) {
        return invoiceRepository.findById(id).get();
    }

    @PostMapping("/products/")
    public HttpStatus addInvoice(@RequestBody Invoice invoice){
        invoiceRepository.save(invoice);

        return HttpStatus.CREATED;
    }
}
