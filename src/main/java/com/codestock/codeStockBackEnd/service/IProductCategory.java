package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.ProductCategory;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the ProductCategory service.
 * It provides methods for managing product categories.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.entity.ProductCategory
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IProductCategory {

    /**
     * Saves the given product category.
     *
     * @param productCategory The product category to be saved.
     * @return The saved product category.
     */
    @Transactional
    ProductCategory save(ProductCategory productCategory);

    /**
     * Deletes the product category with the given product id.
     *
     * @param idProduct The id of the product to be deleted.
     */
    @Transactional
    void deleteByIdProduct(Integer idProduct);

    /**
     * Finds all product categories with the given product id.
     *
     * @param idProduct The id of the product to be found.
     * @return An iterable of all product categories with the given product id.
     */
    @Transactional(readOnly = true)
    Iterable<ProductCategory> findByIdProduct(Integer idProduct);
}