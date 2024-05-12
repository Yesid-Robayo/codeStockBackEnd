package com.codestock.codeStockBackEnd.service;

/**
 * This interface represents the contract for a password hashing service.
 * It provides methods for generating a salt, encoding a password, and verifying a password.
 * It is designed to be implemented by a class that provides the actual password hashing functionality.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IPasswordHash
 */
public interface IPasswordHash {

    /**
     * Encodes a password using a provided salt.
     * This method is intended to be used when a user is creating a new password or changing their existing password.
     * The salt should be generated using a secure random number generator and should be unique for each user.
     *
     * @param password The plain text password to be encoded.
     * @return A string representing the encoded password.
     */
    String encodePassword(String password);

    /**
     * Verifies a plain text password against a hashed password.
     * This method is intended to be used when a user is logging in and their input password needs to be verified against the stored hashed password.
     *
     * @param password The plain text password to be verified.
     * @param hashedPassword The hashed password to verify against.
     * @return A boolean indicating whether the plain text password matches the hashed password.
     */
    boolean verifyPassword(String password, String hashedPassword);
}