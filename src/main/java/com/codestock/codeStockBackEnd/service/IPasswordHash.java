package com.codestock.codeStockBackEnd.service;

/**
 * This interface represents the contract for a password hashing service.
 * It provides methods for generating a salt, encoding a password, and verifying a password.
 */
public interface IPasswordHash {

    /**
     * Generates a new salt for password hashing.
     *
     * @return A string representing the generated salt.
     */
    String generateSalt();

    /**
     * Encodes a password using a provided salt.
     *
     * @param password The plain text password to be encoded.
     * @param salt The salt to be used in the encoding process.
     * @return A string representing the encoded password.
     */
    String encodePassword(String password, String salt);

    /**
     * Verifies a plain text password against a hashed password.
     *
     * @param password The plain text password to be verified.
     * @param hashedPassword The hashed password to verify against.
     * @return A boolean indicating whether the plain text password matches the hashed password.
     */
    boolean verifyPassword(String password, String hashedPassword);
}