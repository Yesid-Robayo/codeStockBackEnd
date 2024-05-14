package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.RolUser;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the RolUser service.
 * It provides methods for managing role users.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.entity.RolUser
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IRolUser {

    /**
     * Saves the given role user.
     *
     * @param rolUser The role user to be saved.
     * @return The saved role user.
     */
    @Transactional
    RolUser save(RolUser rolUser);


    @Transactional
    RolUser findByIdUser(Integer id);
    /**
     * Deletes the role user with the given user id.
     *
     * @param id The id of the user to be deleted.
     */
    @Transactional
    void deleteByIdUser(Integer id);
}