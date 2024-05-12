package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.Password;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Password service.
 * It provides methods for managing passwords.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.entity.Password
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IPassword {

    /**
     * Saves the given password.
     *
     * @param password The password to be saved.
     * @return The saved password.
     */
    @Transactional
    Password save(Password password);

    /**
     * Deletes the password with the given id.
     *
     * @param id The id of the password to be deleted.
     */
    @Transactional
    void delete(Integer id);

    /**
     * Finds the password with the given user id.
     *
     * @param id The id of the user to be found.
     * @return The found password, or null if no password with the given user id exists.
     */
    @Transactional(readOnly = true)
    Password findByIdUser(Integer id);
}