package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Password;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Password entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the Password entity.
 */
public interface PasswordDao extends CrudRepository<Password, Integer> {

    /**
     * This method is used to delete a Password by the user's ID.
     *
     * @param id The ID of the user.
     */
    void deleteByIdUser(Integer id);

    /**
     * This method is used to find a Password by the user's ID.
     *
     * @param id The ID of the user.
     * @return The Password entity if found, null otherwise.
     */
    Password findByIdUser(Integer id);
}