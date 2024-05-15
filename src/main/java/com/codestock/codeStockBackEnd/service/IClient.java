package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.Client;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Client service.
 * It provides methods for managing clients.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.entity.Client
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IClient {

    /**
     * Saves the given client.
     *
     * @param client The client to be saved.
     * @return The saved client.
     */
    @Transactional
    Client save(Client client);

    /**
     * Finds the client with the given person id.
     *
     * @param id The id of the person to be found.
     * @return The client with the given person id.
     */
    @Transactional
    Client findByIdPerson(Integer id);
    /**
     * Deletes the client with the given person id.
     *
     * @param id The id of the person to be deleted.
     */
    @Transactional
    void deleteByIdPerson(Integer id);
}