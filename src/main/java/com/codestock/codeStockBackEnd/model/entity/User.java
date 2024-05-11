package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * This class represents a User entity in the application.
 * It is mapped to the "user" table in the database.
 * It uses Lombok annotations for boilerplate code reduction.
 */
@AllArgsConstructor  // Lombok annotation to generate a constructor with all properties as arguments
@NoArgsConstructor   // Lombok annotation to generate a no-argument constructor
@Data               // Lombok annotation to generate getters, setters, equals, and hashCode methods
@ToString            // Lombok annotation to generate a toString method
@Builder            // Lombok annotation to provide a builder pattern for object creation
@Entity             // JPA annotation to make this class an entity class
@Table(name = "user")
// JPA annotation to specify the details of the table that will be used to create the table in the database
public class User implements Serializable {
    @Id  // JPA annotation to denote the primary key
    @Column(name = "idUser")
    // JPA annotation to specify the details of the column that will be used to create the field in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA annotation to specify the primary key generation strategy
    Integer idUser;

    @Column(name = "email") // JPA annotation to specify the details of the column that will be used to create the field in the database
    String email;

    @Column(name = "idPerson") // JPA annotation to specify the details of the column that will be used to create the field in the database
    Integer idPerson;

}