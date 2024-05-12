package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.ProductOrderDao;
import com.codestock.codeStockBackEnd.model.entity.ProductOrder;
import com.codestock.codeStockBackEnd.service.IProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class represents the ProductOrder service implementation.
 * It implements the IProductOrder interface and provides methods for managing product orders.
 * It uses the ProductOrderDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IProductOrder
 * @see com.codestock.codeStockBackEnd.model.dao.ProductOrderDao
 * @see org.springframework.stereotype.Service
 */
@Service
public class ProductOrderImpl implements IProductOrder {

    private final ProductOrderDao productOrderDao;

    /**
     * Constructor for the ProductOrderImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param productOrderDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public ProductOrderImpl(ProductOrderDao productOrderDao) {
        this.productOrderDao = productOrderDao;
    }

    /**
     * Saves the given product order.
     *
     * @param productOrder The product order to be saved.
     * @return The saved product order.
     */
    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderDao.save(productOrder);
    }

    /**
     * Deletes the product order with the given order id.
     *
     * @param idOrder The id of the order to be deleted.
     */
    @Override
    public void deleteByIdOrder(int idOrder) {
        productOrderDao.deleteById(idOrder);
    }

    /**
     * Finds all product orders by the given order id.
     *
     * @param idOrder The id of the order whose product orders are to be found.
     * @return An iterable of all product orders by the given order id.
     */
    @Override
    public Iterable<ProductOrder> findByIdOrder(int idOrder) {
        return productOrderDao.findByIdOrder(idOrder);
    }


}