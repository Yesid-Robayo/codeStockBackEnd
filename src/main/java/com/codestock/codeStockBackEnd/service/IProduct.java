package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.dto.ProductDTO;
import com.codestock.codeStockBackEnd.model.entity.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Product service.
 * It provides methods for managing products.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.dto.ProductDTO
 * @see com.codestock.codeStockBackEnd.model.entity.Product
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IProduct {

    /**
     * Saves the given product.
     *
     * @param productDTO The product to be saved.
     * @return The saved product.
     */
    @Transactional
    Product save(ProductDTO productDTO);

    /**
     * Deletes the product with the given id.
     *
     * @param id The id of the product to be deleted.
     */
    @Transactional
    void delete(Integer id);

    /**
     * Deletes the product with the given company id.
     *
     * @param id The id of the company to be deleted.
     */
    @Transactional
    void deleteByIdCompany(Integer id);

    /**
     * Finds the product with the given id.
     *
     * @param id The id of the product to be found.
     * @return The found product, or null if no product with the given id exists.
     */
    @Transactional(readOnly = true)
    Product findById(Integer id);

    /**
     * Finds all products.
     *
     * @return An iterable of all products.
     */
    @Transactional(readOnly = true)
    Iterable<Product> findAll();

    /**
     * Finds all products with the given company id.
     *
     * @param IdCompany The id of the company to be found.
     * @return An iterable of all products with the given company id.
     */
    @Transactional(readOnly = true)
    Iterable<Product> findAllByIdCompany(Integer IdCompany);
}