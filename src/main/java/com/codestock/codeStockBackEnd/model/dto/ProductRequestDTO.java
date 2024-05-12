package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;
import java.io.Serializable;
import java.util.List;

/**
 * This class represents the Data Transfer Object (DTO) for the ProductRequest entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the product details along with its prices and categories.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see java.io.Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductRequestDTO implements Serializable {

    /**
     * The ID of the product.
     */
    private Integer idProduct;

    /**
     * The code of the product.
     */
    private String code;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The characteristics of the product.
     */
    private String characteristics;

    /**
     * The ID of the company that owns the product.
     */
    private Integer idCompany;

    /**
     * The list of prices for the product.
     * Each price is represented by an instance of PriceDTO which contains the price details.
     */
    private List<PriceDTO> prices;

    /**
     * The list of categories the product belongs to.
     * Each category is represented by an instance of CategoryDTO which contains the category details.
     */
    private List<CategoryDTO> categories;
}