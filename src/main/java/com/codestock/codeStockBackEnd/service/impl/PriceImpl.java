package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.PriceDao;
import com.codestock.codeStockBackEnd.model.dto.PriceDTO;
import com.codestock.codeStockBackEnd.model.entity.Price;
import com.codestock.codeStockBackEnd.service.IPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Price service implementation.
 * It implements the IPrice interface and provides methods for managing prices.
 * It uses the PriceDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IPrice
 * @see com.codestock.codeStockBackEnd.model.dao.PriceDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class PriceImpl implements IPrice {

    private final PriceDao priceDao;

    /**
     * Constructor for the PriceImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param priceDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public PriceImpl(PriceDao priceDao) {
        this.priceDao = priceDao;
    }

    /**
     * Saves the given price.
     *
     * @param priceDTO The price to be saved.
     * @return The saved price.
     */
    @Override
    @Transactional
    public Price save(PriceDTO priceDTO) {
        return priceDao.save(Price.builder().idCurrency(priceDTO.getIdCurrency()).price(priceDTO.getPrice()).idProduct(priceDTO.getIdProduct()).build());
    }

    /**
     * Deletes the price with the given product id.
     *
     * @param id The id of the product whose price is to be deleted.
     */
    @Override
    @Transactional
    public void deleteByIdProduct(Integer id) {
        priceDao.deleteById(id);
    }

    /**
     * Finds all prices by the given product id.
     *
     * @param id The id of the product whose prices are to be found.
     * @return An iterable of all prices by the given product id.
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Price> findByIdProduct(Integer id) {
        return priceDao.findByIdProduct(id);
    }
}