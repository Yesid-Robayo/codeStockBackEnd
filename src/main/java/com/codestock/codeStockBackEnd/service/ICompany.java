package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.dto.CompanyDTO;
import com.codestock.codeStockBackEnd.model.entity.Company;
import org.springframework.transaction.annotation.Transactional;

/**
 * This interface represents the Company service.
 * It provides methods for managing companies.
 * It is designed to be implemented by a class that interacts with the database.
 * The methods are annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.model.dto.CompanyDTO
 * @see com.codestock.codeStockBackEnd.model.entity.Company
 * @see org.springframework.transaction.annotation.Transactional
 */
public interface ICompany {

    /**
     * Saves the given company.
     *
     * @param companyDTO The company to be saved.
     * @return The saved company.
     */
    @Transactional
    Company save(CompanyDTO companyDTO);

    /**
     * Deletes the company with the given company id.
     *
     * @param id The id of the company to be deleted.
     */
    @Transactional
    void deleteByIdCompany(Integer id);

    /**
     * Finds the company with the given company id.
     *
     * @param id The id of the company to be found.
     * @return The found company, or null if no company with the given company id exists.
     */
    @Transactional(readOnly = true)
    Company findByIdCompany(Integer id);

    /**
     * Finds all companies.
     *
     * @return An iterable of all companies.
     */
    @Transactional(readOnly = true)
    Iterable<Company> findAllCompany();
}