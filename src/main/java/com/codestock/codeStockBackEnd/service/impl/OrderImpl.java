package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.OrderDao;
import com.codestock.codeStockBackEnd.model.entity.Order;
import com.codestock.codeStockBackEnd.service.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Order service implementation.
 * It implements the IOrder interface and provides methods for managing orders.
 * It uses the OrderDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IOrder
 * @see com.codestock.codeStockBackEnd.model.dao.OrderDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class OrderImpl implements IOrder {

    private final OrderDao orderDao;

    /**
     * Constructor for the OrderImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param orderDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public OrderImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * Saves the given order.
     *
     * @param order The order to be saved.
     * @return The saved order.
     */
    @Override
    @Transactional
    public Order save(Order order) {
        return orderDao.save(order);
    }

    /**
     * Deletes the order with the given id.
     *
     * @param id The id of the order to be deleted.
     */
    @Override
    @Transactional
    public void deleteById(Integer id) {
        orderDao.deleteById(id);
    }

    /**
     * Finds all orders by the given client id.
     *
     * @param idClient The id of the client whose orders are to be found.
     * @return An iterable of all orders by the given client id.
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Order> findAllByIdClient(Integer idClient) {
        return orderDao.findAllByIdClient(idClient);
    }

    /**
     * Finds the order with the given id.
     *
     * @param id The id of the order to be found.
     * @return The found order, or null if no order with the given id exists.
     */
    @Override
    @Transactional(readOnly = true)
    public Order findById(Integer id) {
        return orderDao.findById(id).orElse(null);
    }

}