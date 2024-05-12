package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Data Transfer Object (DTO) for the Company entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * The Lombok library annotations are used to reduce boilerplate code.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see java.io.Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CompanyDTO implements Serializable {

    /**
     * The ID of the company.
     */
    private Integer idCompany;

    /**
     * The NIT (Tax Identification Number) of the company.
     */
    private String nit;

    /**
     * The name of the company.
     */
    private String name;

    /**
     * The address of the company.
     */
    private String address;

    /**
     * The phone number of the company.
     */
    private String phone;
}