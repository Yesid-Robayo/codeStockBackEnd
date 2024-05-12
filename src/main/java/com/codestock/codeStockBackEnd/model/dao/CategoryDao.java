package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Category entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the Category entity.
 */
public interface CategoryDao extends CrudRepository<Category, Integer> {

    /**
     * This method is used to find a Category by its name.
     *
     * @param name The name of the Category.
     * @return The Category entity if found, null otherwise.
     */
    Category findByName(String name);
}