package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Client entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
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
 * @see java.io.Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "client")
public class Client implements Serializable {

    /**
     * The ID of the client.
     * It is the primary key of the Client table.
     */
    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idClient;

    /**
     * The ID of the person who is the client.
     * It is a foreign key referencing the Person table.
     */
    @Column(name = "idPerson")
    Integer idPerson;
}