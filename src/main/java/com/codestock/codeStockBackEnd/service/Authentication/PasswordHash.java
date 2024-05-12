package com.codestock.codeStockBackEnd.service.Authentication;

import com.codestock.codeStockBackEnd.service.IPasswordHash;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This class represents the PasswordHash service.
 * It implements the IPasswordHash interface and provides methods for encoding and verifying passwords.
 * It uses the BCryptPasswordEncoder from Spring Security to perform the password operations.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IPasswordHash
 * @see org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
 * @see org.springframework.stereotype.Service
 */
@Service
public class PasswordHash implements IPasswordHash {

    /**
     * Encodes the given password using BCryptPasswordEncoder.
     *
     * @param password The password to be encoded.
     * @return The encoded password.
     */
    @Override
    public String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    /**
     * Verifies the given password against the hashed password using BCryptPasswordEncoder.
     *
     * @param password The password to be verified.
     * @param hashedPassword The hashed password to compare against.
     * @return true if the password does not match the hashed password, false otherwise.
     */
    @Override
    public boolean verifyPassword(String password, String hashedPassword) {
        return !new BCryptPasswordEncoder().matches(password, hashedPassword);
    }
}