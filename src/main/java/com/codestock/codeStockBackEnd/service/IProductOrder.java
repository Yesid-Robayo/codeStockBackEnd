package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.ProductOrder;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the ProductOrder service.
 * It provides methods for managing product orders.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.entity.ProductOrder
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IProductOrder {

    /**
     * Saves the given product order.
     *
     * @param productOrder The product order to be saved.
     * @return The saved product order.
     */
    @Transactional
    ProductOrder save(ProductOrder productOrder);

    /**
     * Deletes the product order with the given order id.
     *
     * @param idOrder The id of the order to be deleted.
     */
    @Transactional
    void deleteByIdOrder(int idOrder);

    /**
     * Finds all product orders with the given order id.
     *
     * @param idOrder The id of the order to be found.
     * @return An iterable of all product orders with the given order id.
     */
    @Transactional
    Iterable<ProductOrder> findByIdOrder(int idOrder);
}