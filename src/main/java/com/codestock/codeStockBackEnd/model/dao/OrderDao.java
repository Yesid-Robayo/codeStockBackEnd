package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Order entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the Order entity.
 */
public interface OrderDao extends CrudRepository<Order, Integer> {

    /**
     * This method is used to find all Orders by the client's ID.
     *
     * @param idClient The ID of the client.
     * @return An Iterable of Order entities if found, empty Iterable otherwise.
     */
    Iterable<Order> findAllByIdClient(Integer idClient);
}