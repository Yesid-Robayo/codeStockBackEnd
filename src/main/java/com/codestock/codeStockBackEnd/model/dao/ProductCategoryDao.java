package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the ProductCategory entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the ProductCategory entity.
 */
public interface ProductCategoryDao extends CrudRepository<ProductCategory, Integer> {

    /**
     * This method is used to find all ProductCategories by the product's ID.
     *
     * @param idProduct The ID of the product.
     * @return An Iterable of ProductCategory entities if found, empty Iterable otherwise.
     */
    Iterable<ProductCategory> findByIdProduct(Integer idProduct);

    /**
     * This method is used to find all ProductCategories by the category's ID.
     *
     * @param idCategory The ID of the category.
     * @return An Iterable of ProductCategory entities if found, empty Iterable otherwise.
     */
    Iterable<ProductCategory> findByIdCategory(Integer idCategory);

    /**
     * This method is used to delete all ProductCategories by the product's ID.
     *
     * @param idProduct The ID of the product.
     */
    void deleteByIdProduct(Integer idProduct);

    /**
     * This method is used to delete a specific ProductCategory by the category's ID and the product's ID.
     *
     * @param idCategory The ID of the category.
     * @param idProduct The ID of the product.
     */
    void deleteByIdCategoryAndIdProduct(Integer idCategory, Integer idProduct);
}