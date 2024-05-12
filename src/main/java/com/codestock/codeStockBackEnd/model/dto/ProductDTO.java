package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Data Transfer Object (DTO) for the Product entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * The Lombok library annotations are used to reduce boilerplate code.
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
public class ProductDTO implements Serializable {

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
}