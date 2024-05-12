package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.dto.UserDTO;
import com.codestock.codeStockBackEnd.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the User service in the application.
 * It provides methods to perform operations on User entities.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.dto.UserDTO
 * @see com.codestock.codeStockBackEnd.model.entity.User
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IUser {

    /**
     * This method is used to save a User entity.
     * It is transactional, meaning that if something goes wrong during the transaction,
     * all changes will be rolled back.
     *
     * @param userDTO The UserDTO object that contains the data to be saved.
     * @return The saved User entity.
     */
    @Transactional
    User save(UserDTO userDTO);

    /**
     * This method is used to delete a User entity by its ID.
     * It is transactional, meaning that if something goes wrong during the transaction,
     * all changes will be rolled back.
     *
     * @param id The ID of the User entity to be deleted.
     */
    @Transactional
    void delete(Integer id);

    /**
     * This method is used to find a User entity by its email.
     * It is read-only, meaning that it does not modify the database.
     *
     * @param email The email of the User entity to be found.
     * @return The found User entity, or null if not found.
     */
    @Transactional(readOnly = true)
    User findByEmail(String email);

    /**
     * This method is used to find a User entity by its person ID.
     * It is read-only, meaning that it does not modify the database.
     *
     * @param id The person ID of the User entity to be found.
     * @return The found User entity, or null if not found.
     */
    @Transactional(readOnly = true)
    User findByIdPerson(Integer id);
}