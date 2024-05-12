package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.dto.CategoryDTO;
import com.codestock.codeStockBackEnd.model.entity.Category;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Category service.
 * It provides methods for managing categories such as saving and finding by id.
 * It is annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.dto.CategoryDTO
 * @see com.codestock.codeStockBackEnd.model.entity.Category
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface ICategory {

    /**
     * Saves the given category.
     *
     * @param categoryDTO The category to be saved.
     * @return The saved category.
     */
    @Transactional
    Category save(CategoryDTO categoryDTO);

    /**
     * Finds the category with the given id.
     *
     * @param id The id of the category to be found.
     * @return The found category, or null if no category with the given id exists.
     */
    @Transactional(readOnly = true)
    Category findByIdCategory(Integer id);
}