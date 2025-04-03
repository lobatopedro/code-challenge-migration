package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();

        assertThat(products)
                .isNotNull()
                .isNotEmpty()
                .allSatisfy(product -> {
                    assertThat(product.getId()).isNotNull();
                    assertThat(product.getTitle()).isNotBlank();
                    assertThat(product.getDescription()).isNotBlank();
                    assertThat(product.getPrice()).isGreaterThan(0);
                });

        assertTrue(products.size() > 0, "Número de produtos retornados: " + products.size());
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;

        Product product = productService.getProductById(productId);

        assertThat(product)
                .isNotNull()
                .extracting(Product::getId, Product::getPrice)
                .containsExactly(productId, product.getPrice());

        assertThat(product.getTitle()).isNotBlank();
        assertThat(product.getDescription()).isNotBlank();
        assertThat(product.getPrice()).isGreaterThan(0);
    }

}
