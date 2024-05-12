package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.ProductOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the ProductOrder entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the ProductOrder entity.
 */
public interface ProductOrderDao extends CrudRepository<ProductOrder, Integer> {

    /**
     * This method is used to find all ProductOrders by the order's ID.
     *
     * @param idOrder The ID of the order.
     * @return An Iterable of ProductOrder entities if found, empty Iterable otherwise.
     */
    Iterable<ProductOrder> findByIdOrder(int idOrder);

    /**
     * This method is used to find a ProductOrder by the product's ID.
     *
     * @param idProduct The ID of the product.
     * @return The ProductOrder entity if found, null otherwise.
     */
    ProductOrder findByIdProduct(int idProduct);
}