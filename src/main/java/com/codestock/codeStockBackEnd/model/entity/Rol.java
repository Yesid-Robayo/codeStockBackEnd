package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Role entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the role details such as name and identifier.
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
@Entity
@Builder
@Table(name = "role")
public class Rol implements Serializable {

    /**
     * The ID of the role.
     * It is the primary key of the Role table.
     */
    @Id
    @Column(name = "idRole")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    /**
     * The name of the role.
     */
    @Column(name = "name")
    private String name;

    /**
     * The identifier of the role.
     */
    @Column(name = "identifier")
    private String identifier;
}