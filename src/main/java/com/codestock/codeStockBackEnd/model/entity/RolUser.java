package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * This class represents the UserRole entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the user and role details for the user role.
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
@Table(name = "user_role")
public class RolUser implements Serializable {

    /**
     * The ID of the user role.
     * It is the primary key of the UserRole table.
     */
    @Id
    @Column(name = "idUserRol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserRole;

    /**
     * The ID of the user.
     * It is a foreign key referencing the User table.
     */
    @Column(name = "idUser")
    private int idUser;

    /**
     * The ID of the role.
     * It is a foreign key referencing the Role table.
     */
    @Column(name = "idRole")
    private int idRole;
}