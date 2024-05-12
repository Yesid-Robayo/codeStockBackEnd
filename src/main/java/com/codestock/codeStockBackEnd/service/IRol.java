package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.Rol;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Rol service.
 * It provides methods for managing roles.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.entity.Rol
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IRol {

    /**
     * Saves the given role.
     *
     * @param rol The role to be saved.
     * @return The saved role.
     */
    @Transactional
    Rol save(Rol rol);

    /**
     * Deletes the role with the given id.
     *
     * @param id The id of the role to be deleted.
     */
    @Transactional
    void delete(Integer id);

    /**
     * Finds the role with the given id.
     *
     * @param id The id of the role to be found.
     * @return The found role, or null if no role with the given id exists.
     */
    @Transactional(readOnly = true)
    Rol findById(Integer id);
}