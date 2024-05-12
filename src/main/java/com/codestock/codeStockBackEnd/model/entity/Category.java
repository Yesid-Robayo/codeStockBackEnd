package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * This class represents the Category entity.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
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
@Table(name = "category")
public class Category {

    /**
     * The ID of the category.
     * It is the primary key of the Category table.
     */
    @Id
    @Column(name = "idCategory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    /**
     * The name of the category.
     */
    @Column(name = "name")
    private String name;
}