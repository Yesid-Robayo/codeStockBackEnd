package com.codestock.codeStockBackEnd.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * This class represents the Data Transfer Object (DTO) for the ChangePass entity.
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
public class ChangePassDTO implements Serializable {

    /**
     * The email of the user who wants to change the password.
     */
    private String email;

    /**
     * The old password of the user.
     */
    private String oldPass;

    /**
     * The new password that the user wants to set.
     */
    private String newPass;

    /**
     * The confirmation of the new password.
     */
    private String confirmPass;
}