package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Client entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the Client entity.
 */
public interface ClientDao extends CrudRepository<Client, Integer> {

    /**
     * This method is used to find a Client by the person's ID.
     *
     * @param id The ID of the person.
     * @return The Client entity if found, null otherwise.
     */
    Client findByIdPerson(Integer id);

    /**
     * This method is used to delete a Client by the person's ID.
     *
     * @param id The ID of the person.
     */
    void deleteByIdPerson(Integer id);
}