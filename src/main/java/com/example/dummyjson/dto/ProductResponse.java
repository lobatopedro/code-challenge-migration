package com.example.dummyjson.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Represents a response containing a list of products retrieved from an external source.
 * This class is typically used to encapsulate product data returned from a service or API call.
 *
 * Attributes:
 * - products: A list of {@link Product} objects representing the products in the response.
 *
 * An instance of this class is populated during the deserialization of a response from a product-related API call.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private List<Product> products;

}
