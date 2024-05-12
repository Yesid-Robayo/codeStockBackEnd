package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Company entity.
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
@Table(name = "company")
public class Company implements Serializable {

    /**
     * The ID of the company.
     * It is the primary key of the Company table.
     */
    @Id
    @Column(name = "idCompany")
    Integer idCompany;

    /**
     * The NIT (Tax Identification Number) of the company.
     */
    @Column(name = "nit")
    String nit;

    /**
     * The name of the company.
     */
    @Column(name = "name")
    String name;

    /**
     * The address of the company.
     */
    @Column(name = "address")
    String address;

    /**
     * The phone number of the company.
     */
    @Column(name = "phone")
    String phone;
}