package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Password entity.
 * It is mapped to the "password" table in the database.
 * It uses Lombok annotations for boilerplate code reduction.
 */
@Data               // Lombok annotation to generate getters, setters, equals, and hashCode methods
@AllArgsConstructor  // Lombok annotation to generate a constructor with all properties as arguments
@NoArgsConstructor   // Lombok annotation to generate a no-argument constructor
@ToString            // Lombok annotation to generate a toString method
@Builder            // Lombok annotation to provide a builder pattern for object creation
@Entity             // JPA annotation to make this object ready for storage in a JPA-based data store
@Table(name = "password") // JPA annotation to specify the details of the table that will be used to create the table in the database
public class Password implements Serializable {

    /**
     * The ID of the Password.
     * It is generated by the database.
     */
    @Id
    @Column(name = "idPassword")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPassword;

    /**
     * The hash of the Password.
     */
    @Column(name = "hash")
    String hash;

    /**
     * The salt of the Password.
     */
    @Column(name = "salt")
    String salt;

    /**
     * The ID of the User associated with this Password.
     */
    @Column(name = "idUser")
    Integer idUser;
}