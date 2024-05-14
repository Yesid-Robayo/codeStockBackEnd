package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.util.Date;

/**
 * This class represents the UserResponse Data Transfer Object (DTO).
 * It is used to transfer data between processes or components.
 * It is annotated with Lombok annotations to reduce boilerplate code.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see lombok.Data
 * @see lombok.AllArgsConstructor
 * @see lombok.NoArgsConstructor
 * @see lombok.ToString
 * @see lombok.Builder
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserResponseDTO {
    /**
     * The name of the user.
     */
    private String name;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The phone number of the user.
     */
    private String phone;

    /**
     * The gender of the user.
     */
    private String gender;

    /**
     * The role of the user.
     */
    private Integer idRole;

    /**
     * The person ID of the user.
     */
    private Integer IdPerson;

    /**
     * The date of birth of the user.
     */
    private Date dateOfBirth;
}