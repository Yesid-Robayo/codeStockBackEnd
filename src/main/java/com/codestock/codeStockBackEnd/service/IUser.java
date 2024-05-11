package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.dto.UserDTO;
import com.codestock.codeStockBackEnd.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the User service in the application.
 * It provides methods to perform operations on User entities.
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
     *
     * @param id The ID of the User entity to be deleted.
     */

    void deleteByIdPerson(Integer id);

    /**
     * This method is used to find a User entity by its ID.
     *
     * @param idPerson The ID of the User entity to be found.
     * @return The found User entity, or null if not found.
     */
    User findByEmail(Integer idPerson);

}