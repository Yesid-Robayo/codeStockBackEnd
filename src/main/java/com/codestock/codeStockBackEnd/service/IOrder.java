package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.Order;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Order service.
 * It provides methods for managing orders.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.entity.Order
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IOrder {

    /**
     * Saves the given order.
     *
     * @param order The order to be saved.
     * @return The saved order.
     */
    @Transactional
    Order save(Order order);

    /**
     * Deletes the order with the given id.
     *
     * @param id The id of the order to be deleted.
     */
    @Transactional
    void deleteById(Integer id);

    /**
     * Finds all orders with the given client id.
     *
     * @param idClient The id of the client to be found.
     * @return An iterable of all orders with the given client id.
     */
    @Transactional
    Iterable<Order> findAllByIdClient(Integer idClient);

    /**
     * Finds the order with the given id.
     *
     * @param id The id of the order to be found.
     * @return The found order, or null if no order with the given id exists.
     */
    @Transactional
    Order findById(Integer id);
}