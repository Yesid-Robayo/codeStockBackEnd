package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.dto.PriceDTO;
import com.codestock.codeStockBackEnd.model.entity.Price;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Price service.
 * It provides methods for managing prices.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.dto.PriceDTO
 * @see com.codestock.codeStockBackEnd.model.entity.Price
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface IPrice {

    /**
     * Saves the given price.
     *
     * @param priceDTO The price to be saved.
     * @return The saved price.
     */
    @Transactional
    Price save(PriceDTO priceDTO);

    /**
     * Deletes the price with the given product id.
     *
     * @param id The id of the product to be deleted.
     */
    @Transactional
    void deleteByIdProduct(Integer id);

    /**
     * Finds all prices with the given product id.
     *
     * @param id The id of the product to be found.
     * @return An iterable of all prices with the given product id.
     */
    @Transactional(readOnly = true)
    Iterable<Price> findByIdProduct(Integer id);
}