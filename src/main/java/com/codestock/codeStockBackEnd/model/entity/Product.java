package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Product entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the product details such as code, name, characteristics, and the company it belongs to.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.Table
 * @see jakarta.persistence.Id
 * @see jakarta.persistence.Column
 * @see jakarta.persistence.GeneratedValue
 * @see jakarta.persistence.GenerationType
 * @see java.io.Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "product")
public class Product implements Serializable {

    /**
     * The ID of the product.
     * It is the primary key of the Product table.
     */
    @Id
    @Column(name = "idProduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    /**
     * The code of the product.
     */
    @Column(name = "code")
    private String code;

    /**
     * The name of the product.
     */
    @Column(name = "name")
    private String name;

    /**
     * The characteristics of the product.
     */
    @Column(name = "characteristics")
    private String characteristics;

    /**
     * The ID of the company that owns the product.
     * It is a foreign key referencing the Company table.
     */
    @Column(name = "idCompany")
    private Integer idCompany;
}