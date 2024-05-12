package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Product entity.
 * It extends the JpaRepository interface from Spring Data JPA to provide CRUD operations for the Product entity.
 * The JpaRepository interface provides methods for CRUD operations, including save, find, delete, and pagination and sorting functionality.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface ProductDao extends JpaRepository<Product, Integer> {

    /**
     * This method is used to find all Products by the company's ID.
     *
     * @param IdCompany The ID of the company.
     * @return An Iterable of Product entities if found, empty Iterable otherwise.
     */
    Iterable<Product> findAllByIdCompany(Integer IdCompany);

    /**
     * This method is used to delete all Products by the company's ID.
     *
     * @param id The ID of the company.
     */
    void deleteByIdCompany(Integer id);
}