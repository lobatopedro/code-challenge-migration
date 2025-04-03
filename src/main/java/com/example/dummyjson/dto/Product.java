package com.example.dummyjson.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Product entity with details including ID, title, description, and price.
 * This class is used to store and transfer product-related data.
 *
 * Attributes are validated to ensure correctness:
 * - The ID must be a non-null Long value within the range [0, 999].
 * - The title, description, and price must not be null.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotNull
    @Min(0L)
    @Max(999L)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Double price;
}
