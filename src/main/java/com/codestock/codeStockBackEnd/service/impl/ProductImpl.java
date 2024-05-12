package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.ProductDao;
import com.codestock.codeStockBackEnd.model.dto.ProductDTO;
import com.codestock.codeStockBackEnd.model.entity.Product;
import com.codestock.codeStockBackEnd.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Product service implementation.
 * It implements the IProduct interface and provides methods for managing products.
 * It uses the ProductDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IProduct
 * @see com.codestock.codeStockBackEnd.model.dao.ProductDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class ProductImpl implements IProduct {

    private final ProductDao productDao;

    /**
     * Constructor for the ProductImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param productDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public ProductImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * Saves the given product.
     *
     * @param productDTO The product to be saved.
     * @return The saved product.
     */
    @Override
    @Transactional
    public Product save(ProductDTO productDTO) {
        return productDao.save(Product.builder().idProduct(productDTO.getIdProduct()).code(productDTO.getCode())
                .name(productDTO.getName()).characteristics(productDTO.getCharacteristics())
                .idCompany(productDTO.getIdCompany()).build());
    }

    /**
     * Deletes the product with the given id.
     *
     * @param id The id of the product to be deleted.
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        productDao.deleteById(id);
    }

    /**
     * Deletes the product with the given company id.
     *
     * @param id The id of the company whose product is to be deleted.
     */
    @Override
    @Transactional
    public void deleteByIdCompany(Integer id) {
        productDao.deleteByIdCompany(id);
    }

    /**
     * Finds the product with the given id.
     *
     * @param id The id of the product to be found.
     * @return The found product, or null if no product with the given id exists.
     */
    @Override
    @Transactional(readOnly = true)
    public Product findById(Integer id) {
        return productDao.findById(id).orElse(null);
    }

    /**
     * Finds all products.
     *
     * @return An iterable of all products.
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * Finds all products by the given company id.
     *
     * @param IdCompany The id of the company whose products are to be found.
     * @return An iterable of all products by the given company id.
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAllByIdCompany(Integer IdCompany) {
        return productDao.findAllByIdCompany(IdCompany);
    }
}