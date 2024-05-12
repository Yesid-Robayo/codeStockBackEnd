package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * This class represents the Order entity.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the order details such as date and the client who made the order.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.Table
 * @see jakarta.persistence.Id
 * @see jakarta.persistence.Column
 * @see jakarta.persistence.GeneratedValue
 * @see jakarta.persistence.GenerationType
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "orden")
public class Order {

    /**
     * The ID of the order.
     * It is the primary key of the Order table.
     */
    @Id
    @Column(name = "idOrden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    /**
     * The date when the order was made.
     */
    @Column(name = "date")
    private Date date;

    /**
     * The ID of the client who made the order.
     * It is a foreign key referencing the Client table.
     */
    @Column(name = "idClient")
    private Integer idClient;
}