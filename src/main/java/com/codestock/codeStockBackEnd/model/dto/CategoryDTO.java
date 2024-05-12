package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Data Transfer Object (DTO) for the Category entity.
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
public class CategoryDTO implements Serializable {

    /**
     * The ID of the category.
     */
    private Integer idCategory;

    /**
     * The name of the category.
     */
    private String name;
}