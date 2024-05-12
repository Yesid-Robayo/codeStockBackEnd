package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;
import java.util.Date;
import java.util.List;

/**
 * This class represents the Data Transfer Object (DTO) for the OrderResponse entity.
 * It is used when the server responds to a client's order request, providing details about the order.
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
public class OrderResponseDTO {

    /**
     * The ID of the order.
     */
    private Integer idOrder;

    /**
     * The date when the order was placed.
     */
    private Date date;

    /**
     * The ID of the client who placed the order.
     */
    private Integer idClient;

    /**
     * The total cost of the order.
     */
    private Double total;

    /**
     * The list of products in the order.
     * Each product is represented by an instance of ProductResponseDTO which contains the product details.
     */
    private List<ProductResponseDTO> products;
}