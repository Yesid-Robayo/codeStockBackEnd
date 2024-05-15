package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;
import java.util.Date;
import java.util.List;

/**
 * This class represents the Data Transfer Object (DTO) for the OrderRequest entity.
 * It is used when a client wants to place an order, capturing the order date, client ID, and the list of products.
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
public class OrderRequestDTO {

    /**
     * The date when the order is placed.
     */
    private Date date;

    /**
     * The ID of the client who is placing the order.
     */
    private Integer idPerson;

    /**
     * The list of products that the client wants to order.
     * Each product is represented by an instance of OrderProductRequestDTO which contains the product ID and the quantity.
     */
    private List<OrderProductRequestDTO> products;
}