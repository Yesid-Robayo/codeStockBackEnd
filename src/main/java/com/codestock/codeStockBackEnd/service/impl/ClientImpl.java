package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.ClientDao;
import com.codestock.codeStockBackEnd.model.entity.Client;
import com.codestock.codeStockBackEnd.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Client service implementation.
 * It implements the IClient interface and provides methods for managing clients.
 * It uses the ClientDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IClient
 * @see com.codestock.codeStockBackEnd.model.dao.ClientDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class ClientImpl implements IClient {

    private final ClientDao clientDao;

    /**
     * Constructor for the ClientImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param clientDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public ClientImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * Saves the given client.
     *
     * @param client The client to be saved.
     * @return The saved client.
     */
    @Override
    @Transactional
    public Client save(Client client) {
        return clientDao.save(client);
    }

    /**
     * Finds the client with the given id.
     *
     * @param id The id of the client to be found.
     * @return The client with the given id.
     */
    @Override
    @Transactional
    public Client findByIdPerson(Integer id) {
        return clientDao.findByIdPerson(id);
    }

    /**
     * Deletes the client with the given id.
     *
     * @param id The id of the client to be deleted.
     */
    @Override
    @Transactional
    public void deleteByIdPerson(Integer id) {
        clientDao.deleteByIdPerson(id);
    }


}