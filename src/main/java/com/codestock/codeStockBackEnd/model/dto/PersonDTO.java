package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * PersonDTO is a Data Transfer Object (DTO) class that represents a person in the system.
 * It is used to transfer data between processes or systems, in a serializable format.
 * It uses Lombok annotations for boilerplate code reduction.
 * It implements Serializable interface for possible serialization.
 * It also uses Lombok's @Builder annotation to implement the Builder pattern.
 */
@Data // Generates getters and setters
@AllArgsConstructor // Generates a constructor with all arguments
@NoArgsConstructor // Generates a no-argument constructor
@ToString // Generates toString method
@Builder // Implements the Builder pattern
public class PersonDTO implements Serializable {

    // Attributes

    /**
     * The id of the person.
     */
    private Integer Id;

    /**
     * The name of the person.
     */
    private String name;

    /**
     * The last name of the person.
     */
    private String lastName;

    /**
     * The date of birth of the person.
     */
    private Date dateOfBirth;

    /**
     * The email of the person.
     */
    private String email;

    /**
     * The phone number of the person.
     */
    private String phone;

    /**
     *  The gender of the person.
     */
    private String gender;

}