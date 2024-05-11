package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * This class represents a Data Transfer Object (DTO) for the User entity.
 * It is used to transfer data between processes or components, in this case, between the application and the client.
 * It uses Lombok annotations for boilerplate code reduction.
 */
@Data               // Lombok annotation to generate getters, setters, equals, and hashCode methods
@AllArgsConstructor  // Lombok annotation to generate a constructor with all properties as arguments
@NoArgsConstructor   // Lombok annotation to generate a no-argument constructor
@ToString            // Lombok annotation to generate a toString method
@Builder            // Lombok annotation to provide a builder pattern for object creation
public class UserDTO implements Serializable {

    /**
     * The id of the User.
     */
    Integer idUser;
    /**
     * The email of the User.
     */
    String email;

    /**
     * The password of the User.
     */
    String password;

    /**
     * The id of the Person.
     */
    Integer idPerson;
}