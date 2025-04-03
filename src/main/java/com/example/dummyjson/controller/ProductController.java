package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller responsible for handling operations related to products.
 * Provides endpoints for retrieving product details.
 */
@RestController
@RequestMapping("/api/products")
@Slf4j
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Retrieves a list of all available products.
     *
     * @return a list of Product objects representing all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        log.info("GET: Retrieving all products");
        return productService.getAllProducts();
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id the unique identifier of the product to retrieve, must not be null
     * @return the Product object corresponding to the specified id
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable @NotNull Long id) {
        log.info("GET: Retrieving product with id {}", id);
        return productService.getProductById(id);
    }

}
