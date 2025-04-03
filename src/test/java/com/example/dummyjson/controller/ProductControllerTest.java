package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    private static final String BASE_URI = "/api/products";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetAllProducts() {
        webTestClient.get()
                .uri(BASE_URI)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product.class)
                .value(products -> assertThat(products).isNotEmpty());
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;

        webTestClient.get()
                .uri(BASE_URI + "/" + productId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Product.class)
                .value(product -> {
                    assertThat(product.getId()).isEqualTo(productId);
                    assertThat(product.getTitle()).isNotEmpty();
                });
    }

}
