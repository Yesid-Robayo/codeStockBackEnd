package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.CategoryDao;
import com.codestock.codeStockBackEnd.model.dto.CategoryDTO;
import com.codestock.codeStockBackEnd.model.entity.Category;
import com.codestock.codeStockBackEnd.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Category service implementation.
 * It implements the ICategory interface and provides methods for managing categories.
 * It uses the CategoryDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.ICategory
 * @see com.codestock.codeStockBackEnd.model.dao.CategoryDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class CategoryImpl implements ICategory {

    private final CategoryDao categoryDao;

    /**
     * Constructor for the CategoryImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param categoryDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public CategoryImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * Saves the given category.
     *
     * @param categoryDTO The category to be saved.
     * @return The saved category.
     */
    @Override
    @Transactional
    public Category save(CategoryDTO categoryDTO) {
        return categoryDao.save(Category.builder().idCategory(categoryDTO.getIdCategory())
                .name(categoryDTO.getName()).build());
    }

    /**
     * Finds all categories.
     *
     * @return The list of all categories.
     */

    @Override
    public Iterable<Category> findAllCategory() {
        return categoryDao.findAll();
    }


    /**
     * Finds the category with the given id.
     *
     * @param id The id of the category to be found.
     * @return The found category, or null if no category with the given id exists.
     */
    @Override
    @Transactional(readOnly = true)
    public Category findByIdCategory(Integer id) {
        return categoryDao.findById(id).orElse(null);
    }

}