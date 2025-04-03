package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductTest {

    @Test
    void testGettersAndSetters() {
        Long expectedId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = 2.1;

        Product product = new Product();
        product.setId(expectedId);
        product.setTitle(expectedTitle);
        product.setDescription(expectedDescription);
        product.setPrice(expectedPrice);

        assertThat(product.getId()).isEqualTo(expectedId);
        assertThat(product.getTitle()).isEqualTo(expectedTitle);
        assertThat(product.getDescription()).isEqualTo(expectedDescription);
        assertThat(product.getPrice()).isEqualTo(expectedPrice);
    }

}

