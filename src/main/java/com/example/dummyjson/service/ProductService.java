package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Service layer responsible for managing the retrieval of product-related data.
 * Communicates with an external API using a WebClient to fetch product details.
 * Provides methods for retrieving all available products or a specific product by its unique identifier.
 */
@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Product> getAllProducts() {
        return Optional.ofNullable(
                        webClient.get()
                                .uri("/products")
                                .retrieve()
                                .bodyToMono(ProductResponse.class)
                                .block()
                )
                .map(ProductResponse::getProducts)
                .orElseGet(Collections::emptyList);
    }


    public Product getProductById(Long id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

}
