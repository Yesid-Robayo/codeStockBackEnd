package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents a Data Transfer Object (DTO) for the UserRequest entity.
 * It is used to transfer data between processes or components, in this case, between the application and the client.
 * It uses Lombok annotations for boilerplate code reduction.
 */
@Data               // Lombok annotation to generate getters, setters, equals, and hashCode methods
@AllArgsConstructor  // Lombok annotation to generate a constructor with all properties as arguments
@NoArgsConstructor   // Lombok annotation to generate a no-argument constructor
@ToString            // Lombok annotation to generate a toString method
@Builder            // Lombok annotation to provide a builder pattern for object creation
public class UserRequestDTO implements Serializable {

    /**
     * The name of the Person.
     */
    private String name;

    /**
     * The last name of the Person.
     */
    private String lastName;

    /**
     * The date of birth of the Person.
     */
    private Date dateOfBirth;

    /**
     * The phone number of the Person.
     */
    private String phone;

    /**
     * The gender of the Person.
     */
    private String gender;

    /**
     * The email of the User.
     */
    private String email;

    /**
     * The password of the User.
     */
    private String password;
}