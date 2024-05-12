package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;
import java.io.Serializable;

/**
 * This class represents the Data Transfer Object (DTO) for the Price entity.
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
public class PriceDTO implements Serializable {

    /**
     * The ID of the currency used for the price.
     */
    private Integer idCurrency;

    /**
     * The price of the product.
     */
    private Double price;

    /**
     * The ID of the product for which the price is set.
     */
    private Integer idProduct;
}