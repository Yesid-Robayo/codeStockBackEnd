package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.ProductCategoryDao;
import com.codestock.codeStockBackEnd.model.entity.ProductCategory;
import com.codestock.codeStockBackEnd.service.IProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the ProductCategory service implementation.
 * It implements the IProductCategory interface and provides methods for managing product categories.
 * It uses the ProductCategoryDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IProductCategory
 * @see com.codestock.codeStockBackEnd.model.dao.ProductCategoryDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class ProductCategoryImpl implements IProductCategory {

    private final ProductCategoryDao productCategoryDao;

    /**
     * Constructor for the ProductCategoryImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param productCategoryDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public ProductCategoryImpl(ProductCategoryDao productCategoryDao) {
        this.productCategoryDao = productCategoryDao;
    }

    /**
     * Saves the given product category.
     *
     * @param productCategory The product category to be saved.
     * @return The saved product category.
     */
    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }

    /**
     * Deletes the product category with the given product id.
     *
     * @param idProduct The id of the product whose category is to be deleted.
     */
    @Override
    @Transactional
    public void deleteByIdProduct(Integer idProduct) {
        productCategoryDao.deleteByIdProduct(idProduct);
    }



    /**
     * Finds all product categories by the given product id.
     *
     * @param idProduct The id of the product whose categories are to be found.
     * @return An iterable of all product categories by the given product id.
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductCategory> findByIdProduct(Integer idProduct) {
        return productCategoryDao.findByIdProduct(idProduct);
    }

}