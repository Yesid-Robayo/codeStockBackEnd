package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

/**
 * This class represents the Data Transfer Object (DTO) for the OrderProductRequest entity.
 * It is used when a client wants to order a product, capturing the product ID and the quantity desired.
 * The Lombok library annotations are used to reduce boilerplate code.
 *
 * @author Yesid-Robayo
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderProductRequestDTO {

    /**
     * The ID of the product that the client wants to order.
     */
    private Integer idProduct;

    /**
     * The quantity of the product that the client wants to order.
     */
    private Integer quantity;
}