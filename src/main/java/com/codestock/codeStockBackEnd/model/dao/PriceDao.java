package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Price;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Price entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the Price entity.
 */
public interface PriceDao extends CrudRepository<Price, Integer> {

    /**
     * This method is used to find all Prices by the product's ID.
     *
     * @param id The ID of the product.
     * @return An Iterable of Price entities if found, empty Iterable otherwise.
     */
    Iterable<Price> findByIdProduct(Integer id);
}