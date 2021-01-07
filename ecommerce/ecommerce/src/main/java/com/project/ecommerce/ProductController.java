package com.project.ecommerce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping("/product/")
    public Iterable<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping("/products/")
    public HttpStatus addProduct(@RequestBody Product product){
        productRepository.save(product);

        return HttpStatus.CREATED;
    }
}